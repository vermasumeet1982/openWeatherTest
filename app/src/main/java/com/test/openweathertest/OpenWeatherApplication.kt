package com.test.openweathertest

import android.app.Application

class OpenWeatherApplication : Application() {

    val component : OpenWeatherComponent by lazy {
        DaggerOpenWeatherComponent.builder()
                .mainModule(MainModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}