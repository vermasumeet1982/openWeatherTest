package com.test.openweathertest.dagger

import com.test.openweathertest.kt.MainActivity
import com.test.openweathertest.jv.WeatherActivityJava
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun bindWeatherActivityJava() : WeatherActivityJava
}