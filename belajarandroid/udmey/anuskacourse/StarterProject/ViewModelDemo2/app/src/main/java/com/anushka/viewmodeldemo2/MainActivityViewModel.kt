package com.anushka.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
//    private var total = 0

    // livedata tidak aman karena tidak ada private funsi
    // var total = MutableLiveData<Int>()
    
    // cara membuat lebih aman
    private var total = MutableLiveData<Int>()
    
    val totalData : LiveData<Int>
    get() = total


    init {
        total.value = startingTotal
    }

//    fun getTotal():Int{
//        return total
//    }

    //livedata
        fun setTotal(input:Int){
        total.value =(total.value)?.plus(input)
    }

//    fun setTotal(input:Int){
//        total +=input
//    }
}