package com.example.tmdbclient.data.repository.artist.datasourceimpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceimpl(
    private val tmdbService : TMDBService,
    private val apiKey:String
    ): ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopoularArtist(apiKey)

}