package com.anushka.didemo

import android.util.Log
import javax.inject.Inject

class NikelBattrey @Inject constructor(): Battery{
    override fun getPower() {
        super.getPower()
        Log.i("MYTAG","Battery power is Made By Nikel")
    }
}