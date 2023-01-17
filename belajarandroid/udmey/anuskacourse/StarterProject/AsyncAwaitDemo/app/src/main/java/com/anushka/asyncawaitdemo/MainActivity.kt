package com.anushka.asyncawaitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(Main).launch {

            Log.i("MyTag", "Mulai Menghitung!!!!!!!")
//            val stock1 = getStock1() // biasa tidak paralel
            val stock1 = async(IO) {    // menambahkan IO untuk menggunakan Dispacher thread dari backroynd untuk menggunakan thread paralel dari main thread
                getStock1()
            }// pararlel way
            val stock2 = async(IO) {
                getStock2()
            }// async adalah sistem parelel
            val total = stock1.await()+stock2.await()// untuk mengeluarkan async adalah menggunakan await disetiap fungsi
            Toast.makeText(applicationContext,"Total : $total" , Toast.LENGTH_LONG).show()
            Log.i("MyTag", "Total : $total")


        }

    }
}


// sistem await untuk menunggu hasil return menggunakan delay
private suspend fun getStock1() : Int {
    delay(10000)
    Log.i("MyTag", "Stock 1 return")
    return 55000
}



private suspend fun getStock2() : Int {
    delay(8000)
    Log.i("MyTag", "Stock 2 return")
    return 35000
}