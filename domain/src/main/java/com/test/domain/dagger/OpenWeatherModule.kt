package com.test.domain.dagger

import com.test.domain.openweather.OpenWeatherAPI
import com.test.domain.openweather.OpenWeatherService
import com.test.domain.openweather.OpenWeatherServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OpenWeatherModule {


    @Provides @Singleton fun provideOpenWeatherAPI() : OpenWeatherAPI {
        
    }

    @Provides @Singleton fun provideOpenWeatherService(openWeatherAPI: OpenWeatherAPI) : OpenWeatherService {

        return OpenWeatherServiceImpl(openWeatherAPI)
    }
}