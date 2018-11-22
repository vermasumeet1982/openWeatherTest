package com.test.openweathertest

import com.test.domain.openweather.OpenWeatherRepositoryRx
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OpenWeatherAppModule {


    @Provides @Singleton fun provideOpenWeatherViewModelFactory(openWeatherRepositoryRx: OpenWeatherRepositoryRx) : OpenWeatherViewModelFactory {
        return OpenWeatherViewModelFactory(openWeatherRepositoryRx)
    }


}