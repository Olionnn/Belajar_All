package com.example.tmdbclient.data.repository.artist

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistCacheDatasource: ArtistCacheDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistRemoteDatasource: ArtistRemoteDatasource

): ArtistRepository {


    override suspend fun getArtist(): List<Artist>? {
        return getArtisFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtist = getArtistFromApi()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveMovieToDB(newListOfArtist)
        artistCacheDatasource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromApi():List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDatasource.getArtistFromDB()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size>0){
            artistList = getArtistFromApi()
            artistLocalDatasource.saveMovieToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtisFromCache():List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDatasource.getArtistFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size>0){
            artistList = getArtistFromDB()
            artistCacheDatasource.saveArtistToCache(artistList)
        }

        return artistList
    }


}