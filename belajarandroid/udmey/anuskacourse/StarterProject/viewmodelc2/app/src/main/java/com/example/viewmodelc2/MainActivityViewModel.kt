package com.example.viewmodelc2

import androidx.lifecycle.ViewModel


class MainActivityViewModel : ViewModel() {

    private var count = 0
    fun getCurrentCount():Int{
        return count
    }

    // dengan mengubah string ke int
//    fun getUpdatedCount(uwu: String):Int{
//        val iwi = uwu.toInt()
//        count += iwi
//        return count
//    }
    // tampa mengubah string ke int
    fun getUpdated(uwu : Int) {
        count += uwu
    }
}