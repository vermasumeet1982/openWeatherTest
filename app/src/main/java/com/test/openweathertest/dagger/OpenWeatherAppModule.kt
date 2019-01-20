package com.test.openweathertest.dagger

import com.test.domain.openweather.OpenWeatherRepositoryRx
import com.test.domainjava.openweatherjava.OpenWeatherJavaRepositoryRx
import com.test.openweathertest.kt.OpenWeatherViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OpenWeatherAppModule {


    @Provides @Singleton fun provideOpenWeatherViewModelFactory(openWeatherRepositoryRx: OpenWeatherRepositoryRx, openWeatherJavaRepositoryRx: OpenWeatherJavaRepositoryRx) : OpenWeatherViewModelFactory {
        return OpenWeatherViewModelFactory(openWeatherRepositoryRx, openWeatherJavaRepositoryRx)
    }


}