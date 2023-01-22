package com.example.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class CompresingWorker(context: Context, params:WorkerParameters) : Worker(context,params) {

    override fun doWork(): Result {

        try {
            for (i in 0 .. 300){
                Log.i("MYTAG", "Compresing $i")
            }

            return Result.success()
        } catch (e:Exception){
            return Result.failure()
        }


    }
}