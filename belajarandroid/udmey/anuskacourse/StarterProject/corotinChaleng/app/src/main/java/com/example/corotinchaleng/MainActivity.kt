package com.example.corotinchaleng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        CoroutineScope(Dispatchers.Main).launch {
            for (i in 1 .. 1000) {
                Log.i("MainThread","Coroutine Launch From Main $i Thread ${Thread.currentThread().name}")
            }
        }


        CoroutineScope(Dispatchers.IO).launch {
            for (a in 1 ..1000) {
                Log.i("BackgroundThread" , "Coroutine Launch Background $a Thread ${Thread.currentThread().name}")
            }
        }
    }
}