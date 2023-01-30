package com.anushka.didemo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class,NCBatteryModule::class])
interface SmartPhoneComponent {
    //fun getSmartPhone() : SmartPhone

    //field injection dagger
    fun inject(mainActivity : MainActivity )
}