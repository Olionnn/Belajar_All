package com.anushka.coroutinesdemo1

import kotlinx.coroutines.*

class UserDataManager2 {

    suspend fun getTotalUserCount(): Int {
        var count = 0
        lateinit var deferred: Deferred<Int>
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 5
            }
            deferred = async (Dispatchers.IO) {
                delay(3000)
                return@async 70
            }
        }


        return count + deferred.await()
    }



}