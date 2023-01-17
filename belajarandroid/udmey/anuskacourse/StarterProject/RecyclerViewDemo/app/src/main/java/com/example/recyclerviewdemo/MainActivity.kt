package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val namaorang = listOf<Siswa>(
        Siswa("ardi",12),
        Siswa("naya" , 11),
        Siswa("agil",10),
        Siswa("udin",12),
        Siswa("tokimen",12),
        Siswa("kris",12),
        Siswa("naihs",12),
        Siswa("anjau",12),
        Siswa("bibu",11))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(
            namaorang,
        ) { selectedItem: Siswa
         -> listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(siswa: Siswa) {
        Toast.makeText(
            this@MainActivity,
            "Nama : ${siswa.name}, Kelas : ${siswa.kelas}",
            Toast.LENGTH_LONG
        ).show()
    }
}