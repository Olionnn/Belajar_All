package com.example.notificationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent


import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    private val channelID = "com.example.notificationdemo.channel1"
    private var notificationManager:NotificationManager? = null
    private val KEY_REPLAY = "Key_rep"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID, "DemoChannel", "This Demo Notification")

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            displayNotification()
        }



    }


    private fun displayNotification(){
        val notificationID = 45

        val tapResultIntent = Intent(this,SecondActivity::class.java)
        val pendingIntent:PendingIntent = PendingIntent.getActivity(
            this,0,
            tapResultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        //replay Action
        val remoteInput: RemoteInput = RemoteInput.Builder(KEY_REPLAY).run {
            setLabel("Insert Your Name")
            build()
        }

        val replayAction : NotificationCompat.Action = NotificationCompat.Action.Builder(
            0,
            "REPLY",
            pendingIntent
        ).addRemoteInput(remoteInput).build()

        //action button to detail
        val intent2 = Intent(this,DetailActivity::class.java)
        val pendingIntent2:PendingIntent = PendingIntent.getActivity(
            this,0,
            intent2,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        //action button to setting
        val intent3 = Intent(this,SettingActivity::class.java)
        val pendingIntent3:PendingIntent = PendingIntent.getActivity(
            this,0,
            intent3,
            PendingIntent.FLAG_UPDATE_CURRENT
        )


        val action2 : NotificationCompat.Action =
            NotificationCompat.Action.Builder(0,"Details",pendingIntent2).build()

        val action3 : NotificationCompat.Action =
            NotificationCompat.Action.Builder(0,"Setting",pendingIntent3).build()

        val notification = NotificationCompat.Builder(this@MainActivity,channelID)
            .setContentTitle("Title NOtification")
            .setContentText("Text Notification")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setContentIntent(pendingIntent)
            .addAction(action2)
            .addAction(action3)
            .addAction(replayAction)
            .build()
        notificationManager?.notify(notificationID,notification)



    }

    private fun createNotificationChannel(id : String, name : String, channelDescription : String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id,name,importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }

}


