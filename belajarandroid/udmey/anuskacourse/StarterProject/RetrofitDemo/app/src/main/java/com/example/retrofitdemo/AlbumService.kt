package com.example.retrofitdemo

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbum() : Response<Album>

    //Query Parameter
    @GET("/albums")
    suspend fun getSortedAlbum(@Query("userId") userId:Int) : Response<Album>


    //Path Paarameter
    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId:Int) : Response<AlbumItem>

    //POST ARGUMENT
    @POST("/albums")
    suspend fun uploadAlbum(@Body album:AlbumItem) : Response<AlbumItem>

}