package com.example.retrofitdemo

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object {

        // okhttp loging inceptor libary
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
            // timeout request
                    // digunakan untuk waktu mengoneksikan client to server
                .connectTimeout(30,TimeUnit.SECONDS)
                    // waktu maksimal dari membaca data dari server ke client (time gap arrival to data paket)
                .readTimeout(20,TimeUnit.SECONDS)
                    // menampilkan data ke cliet screen
                .writeTimeout(25,TimeUnit.SECONDS)
        }.build()
        // note = okhttp berguna untuk mengetahui error yang didapat dari api 200 300 400 contohnya

        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun getRetrofitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                    // add client dari logging to retrofit
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

    }
}