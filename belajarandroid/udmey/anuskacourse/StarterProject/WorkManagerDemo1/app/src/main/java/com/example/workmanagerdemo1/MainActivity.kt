
package com.example.workmanagerdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY_COUNT_VALUE = "key_count"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttons = findViewById<Button>(R.id.button)


        buttons.setOnClickListener {
            //setOneTimeWorkRequest()
            setPeriodicWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest(){
        val textS = findViewById<TextView>(R.id.textView)
        val workManager = WorkManager.getInstance(applicationContext)

        // input and output Data
        val data:Data = Data.Builder()
            .putInt(KEY_COUNT_VALUE, 125)
            .build()

        //get Constraints
       val constraints = Constraints.Builder()
           .setRequiresCharging(true)
           .setRequiredNetworkType(NetworkType.CONNECTED)
           .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()


        //Chaning Worker
        val filteringWorker = OneTimeWorkRequest.Builder(FilteringWorker::class.java)
            .build()

        val compresingWorker = OneTimeWorkRequest.Builder(CompresingWorker::class.java)
            .build()

        val downloadWorker = OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
            .build()

        // mutable list
        val paralleWorks = mutableListOf<OneTimeWorkRequest>()
        paralleWorks.add(downloadWorker)
        paralleWorks.add(filteringWorker)

        //WorkManager.getInstance(applicationContext)
        workManager
            .beginWith(paralleWorks)
            .then(compresingWorker)
            .then(uploadRequest)
            .enqueue()

        // without channing worker
        //workManager.enqueue(uploadRequest)

        // getStatus Update From Worker
        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, Observer {
                textS.text = it.state.name
                if (it.state.isFinished){
                    val data = it.outputData
                    val massage = data.getString(UploadWorker.KEY_WORKER)
                     Toast.makeText(applicationContext,massage,Toast.LENGTH_LONG).show()
                }
            })
    }



    private fun setPeriodicWorkRequest(){
        val periodicWorkRequest = PeriodicWorkRequest
            .Builder(DownloadingWorker::class.java,16,TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(periodicWorkRequest)

    }


}