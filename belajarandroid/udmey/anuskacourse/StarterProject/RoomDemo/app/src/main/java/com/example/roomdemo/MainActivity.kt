package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.databinding.ActivityMainBinding
import com.example.roomdemo.db.Subscriber
import com.example.roomdemo.db.SubscriberDatabase
import com.example.roomdemo.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    private lateinit var adapter: MyRecylerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDao
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory)[SubscriberViewModel::class.java]
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this


        //displaySubscribersList()
        initRecyclerView()

        subscriberViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })


    }
    // Menampilkan Data Dengan RecyleView
    private fun initRecyclerView(){
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this,)
        //speed
        adapter = MyRecylerViewAdapter({selectedItem:Subscriber->listItemClicker(selectedItem)})
        binding.subscriberRecyclerView.adapter = adapter

        displaySubscribersList()

    }
    // Menampillkan Data Dalam LogChat Tag:
    private fun displaySubscribersList(){

        // Mengunakan Live Data
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.i("MYTAG",it.toString())
           // binding.subscriberRecyclerView.adapter = MyRecylerViewAdapter(it,{selectedItem:Subscriber->listItemClicker(selectedItem)})

            //speed
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })

        // Menggunakan Flow
//        subscriberViewModel.getSavedSubscribers().observe(this, Observer {
//            adapter.setList(it)
//            adapter.notifyDataSetChanged()
//        })

    }

    // Memilih Item
    private fun listItemClicker(subscriber: Subscriber){
        //Toast.makeText(this,"dipilih naama ${subscriber.email}", Toast.LENGTH_LONG).show()
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }

}
