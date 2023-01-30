package com.anushka.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    // instance variable
    @Inject lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        DaggerSmartPhoneComponent.create()
//            //.getSmartPhone()
//            .inject(this)
//            //.makeACallWithRecording()
//        smartPhone.makeACallWithRecording()

        // bekerja dengan mengirim data yang mempunyai value
//        DaggerSmartPhoneComponent.builder()
//            .memoryCardModule(MemoryCardModule(1000))
//            .build()
//            .inject(this)

        // subclass application
        (application as SmartPhoneApplication).smartPhoneComponent
            .inject(this)
        smartPhone.makeACallWithRecording()

        // DI without Dagger (Clean DI)
        // biginer way
//        val battery = Battery()
//        val memoryCard = MemoryCard()
//        val serviceProvider = ServiceProvider()
//        val simCard = SIMCard(serviceProvider)
//        val smartPhone = SmartPhone(battery, simCard, memoryCard)

        //eficient way
//        val smartPhone = SmartPhone(
//            // didalam kurung ini adalah DI
//            Battery(),
//            SIMCard(ServiceProvider()),
//            MemoryCard()
//        ).makeACallWithRecording()






    }
}
