package com.test.openweathertest

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule (val app: OpenWeatherApplication) {

    @Provides @Singleton fun provideApp() = app
}