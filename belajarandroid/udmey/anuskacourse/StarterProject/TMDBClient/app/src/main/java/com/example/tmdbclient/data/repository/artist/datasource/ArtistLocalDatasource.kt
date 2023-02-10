package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistLocalDatasource {

    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveMovieToDB(artist: List<Artist>)
    suspend fun clearAll()
}