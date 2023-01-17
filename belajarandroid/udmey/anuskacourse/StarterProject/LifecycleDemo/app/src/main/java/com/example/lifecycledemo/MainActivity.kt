package com.example.lifecycledemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch(Dispatchers.IO) {
            // memunculkan progress bar untuk main actifity mengunakan lifecycle
//            var progressBar = findViewById<ProgressBar>(R.id.progressBar)
//            delay(5000)
//            progressBar.visibility = View.VISIBLE
//            delay(10000)
//            progressBar.visibility = View.GONE

            // contect lifecyle launch(dispacher.io)
            Log.i("UwU", "Thread INI Di : ${Thread.currentThread().name}")

        }

        lifecycleScope.launchWhenCreated {

        }

        lifecycleScope.launchWhenStarted {

        }

        lifecycleScope.launchWhenResumed {

        }


    }
}