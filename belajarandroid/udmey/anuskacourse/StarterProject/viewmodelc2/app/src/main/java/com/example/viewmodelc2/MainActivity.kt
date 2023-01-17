package com.example.viewmodelc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelc2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // import data
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // sc variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.textView.text = viewModel.getCurrentCount().toString()

        // mengubah string ke int di view model
//        binding.button.setOnClickListener {
//            val update : String = binding.editText.text.toString()
//            binding.textView.text = viewModel.getUpdatedCount(update).toString()
//        }

        // langsung mengubah string ke int
        binding.button.setOnClickListener {
            viewModel.getUpdated(binding.editText.text.toString().toInt())
            binding.textView.text = viewModel.getCurrentCount().toString()
        }

    }
}

