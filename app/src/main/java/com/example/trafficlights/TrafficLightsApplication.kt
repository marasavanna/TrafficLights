package com.example.trafficlights

import android.app.Application
import com.example.trafficlights.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TrafficLightsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TrafficLightsApplication)
            modules(viewModelModule)
        }
    }
}