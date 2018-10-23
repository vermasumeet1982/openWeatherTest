package com.test.openweathertest

import com.test.domain.dagger.OpenWeatherModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MainModule::class, OpenWeatherModule::class))
interface OpenWeatherComponent {

    fun inject(app: OpenWeatherApplication)
}