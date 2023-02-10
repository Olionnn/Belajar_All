package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasouce
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowCacheDatasouce: TvShowCacheDatasouce,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowRemoteDatasource: TvShowRemoteDatasource
):TvShowRepository {
    override suspend fun getTvShow(): List<TvShow>? {
       return getTvShowFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val newListOfTvShow = getTvShowFromApi()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDatasouce.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowFromApi():List<TvShow>{

        lateinit var tvShowList: List<TvShow>

        try{
            val response = tvShowRemoteDatasource.getTvShow()
            val body = response.body()
            if (body != null){
                tvShowList = body.tvShows
            }
        } catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDatasource.getTvShowFromDB()
        }catch (exception:Exception){
            tvShowList = getTvShowFromApi()
            tvShowLocalDatasource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDatasouce.getTvShowFromCache()
        }catch (exception:Exception){
            tvShowList = getTvShowFromDB()
            tvShowCacheDatasouce.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

}