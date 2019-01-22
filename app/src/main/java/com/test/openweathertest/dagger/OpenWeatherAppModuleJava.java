package com.test.openweathertest.dagger;

import com.test.domain.openweather.OpenWeatherRepositoryRx;
import com.test.domainjava.openweatherjava.OpenWeatherJavaRepositoryRx;
import com.test.openweathertest.jv.OpenWeatherViewModelFactoryJava;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class OpenWeatherAppModuleJava {


    @Provides @Singleton
    public OpenWeatherViewModelFactoryJava provideOpenWeatherViewModelFactory(OpenWeatherRepositoryRx openWeatherRepositoryRx,
                                                                              OpenWeatherJavaRepositoryRx openWeatherJavaRepositoryRx) {
        return new OpenWeatherViewModelFactoryJava(openWeatherRepositoryRx, openWeatherJavaRepositoryRx);
    }


}