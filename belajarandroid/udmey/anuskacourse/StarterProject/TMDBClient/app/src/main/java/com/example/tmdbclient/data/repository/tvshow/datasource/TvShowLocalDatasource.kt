package com.example.tmdbclient.data.repository.tvshow.datasource


import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowFromDB():List<TvShow>
    suspend fun saveTvShowToDB(tvshow : List<TvShow>)
    suspend fun clearAll()
}