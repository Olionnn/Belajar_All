package com.example.tmdbclient.data.repository.movie.datasourceimpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasouce
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String

    ): MovieRemoteDatasouce {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopoularMovies(apiKey)


}