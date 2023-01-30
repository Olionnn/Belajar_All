package com.anushka.didemo

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize:Int) {

    // status modul (mengirim data dari modul)
    @Provides
    fun providesMemoryCard() : MemoryCard {
        Log.i("MyTag" ,"Memory Tersisa $memorySize")
        return MemoryCard()
    }
}