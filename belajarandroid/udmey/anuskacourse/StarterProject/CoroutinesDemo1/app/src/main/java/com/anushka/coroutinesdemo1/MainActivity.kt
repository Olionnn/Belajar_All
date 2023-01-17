package com.anushka.coroutinesdemo1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var btnDownloadUserData : Button
    private lateinit var btnCount : Button
    private lateinit var tvCount : TextView
    private lateinit var tvUserMassage : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)

        tvUserMassage = findViewById(R.id.tvUserMessage)
        btnCount = findViewById(R.id.btnCount)
        tvCount = findViewById(R.id.tvCount)
        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }


        btnDownloadUserData.setOnClickListener {
            // corotin
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }

        }
    }

    private suspend fun downloadUserData() {
//        val iman = tvCount.text.toString().toInt()
                    // thread show on log
            // Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
            // showing thread on android display
            // untuk menggunakan withcontext jadikan suspend function
            withContext(Dispatchers.Main){
                for (i in 1..20000) {
                    tvUserMassage.text = "Downloading user $i in ${Thread.currentThread().name}"
                    delay(1000)
                }
            }
    }
}