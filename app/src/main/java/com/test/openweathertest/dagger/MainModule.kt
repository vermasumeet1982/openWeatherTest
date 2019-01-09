package com.test.openweathertest.dagger

import com.test.openweathertest.OpenWeatherApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule (val app: OpenWeatherApplication) {

    @Provides @Singleton fun provideApp() = app

    @Provides @Singleton fun provideContext() = app.applicationContext
}