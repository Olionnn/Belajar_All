package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    //Listing Data From Api

    //movie
    @GET("movie/popular")
    suspend fun getPopoularMovies(
        @Query(
            "api_key"
        )apiKey:String
    ): Response<MovieList>

    //tvShows
    @GET("tv/popular")
    suspend fun getPopoularTvShows(
        @Query(
            "api_key"
        )apiKey:String
    ): Response<TvShowList>

    //Artis
    @GET("person/popular")
    suspend fun getPopoularArtist(
        @Query(
            "api_key"
        )apiKey:String
    ): Response<ArtistList>


}