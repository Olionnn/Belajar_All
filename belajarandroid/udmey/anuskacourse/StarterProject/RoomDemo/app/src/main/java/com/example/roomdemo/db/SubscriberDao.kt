package com.example.roomdemo.db

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface SubscriberDao {
    //@Insert(onConflict = OnConflictStrategy.REPLACE)

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber): Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber): Int

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscriber():LiveData<List<Subscriber>>
    // Jika Menuungakan Flow
    // Agar Program Bisa Dipake Untuk Ios Dan Android Dengan Murni Kotlin Code
    //fun getAllSubscriber(): Flow<List<Subscriber>>
}