package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasouce {
    suspend fun getMovies(): Response<MovieList>
}