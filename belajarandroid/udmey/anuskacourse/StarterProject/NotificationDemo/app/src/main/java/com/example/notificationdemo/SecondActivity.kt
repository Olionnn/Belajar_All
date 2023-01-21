package com.example.notificationdemo


import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        receveInput()
    }

    private fun receveInput(){
        val textS = findViewById<TextView>(R.id.textView3)
        val KEY_REPLAY = "Key_rep"
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null){
            val inputString = remoteInput.getCharSequence(KEY_REPLAY).toString()
            textS.text = inputString

            // Update Screen Mengirim Pesana
            val channelID = "com.example.notificationdemo.channel1"
            val notificationID = 45

            val repliedNotification = NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText(textS.text)
                .build()
            val notificationManager : NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationID,repliedNotification)
        }
    }
}