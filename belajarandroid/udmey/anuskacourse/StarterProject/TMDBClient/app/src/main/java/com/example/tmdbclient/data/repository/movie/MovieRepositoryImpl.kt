package com.example.tmdbclient.data.repository.movie

import android.util.Log
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasouce
import com.example.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasouce : MovieRemoteDatasouce,
    private val movieLocalDatasouce : MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
    ) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovie(): List<Movie>? {
        val newListOfMovie = getMovieFromApi()
        movieLocalDatasouce.clearAll()
        movieLocalDatasouce.saveMovieToDB(newListOfMovie)
        movieCacheDatasource.saveMoviesToCache(newListOfMovie)
        return newListOfMovie
    }

    suspend fun getMovieFromApi():List<Movie>{
        // declear list data
        lateinit var movieList:List<Movie>

        //exception handler
        try {
            val response = movieRemoteDatasouce.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("My Tag",exception.message.toString())
        }
        return movieList
    }

    suspend fun getMovieFromDB():List<Movie>{
        lateinit var movieList:List<Movie>

        try{
            movieList = movieLocalDatasouce.getMovieFromDB()


        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        } else {
            movieList = getMovieFromApi()
            movieLocalDatasouce.saveMovieToDB(movieList)
        }
        return movieList
    }

    suspend fun getMovieFromCache():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDatasource.getMovieFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }else {
            movieList= getMovieFromDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }

        return movieList
    }


}