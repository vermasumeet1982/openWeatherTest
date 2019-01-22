package com.test.openweathertest.jv;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.test.domain.openweather.OpenWeatherRepositoryRx;
import com.test.domainjava.openweatherjava.OpenWeatherJavaRepositoryRx;

public class OpenWeatherViewModelFactoryJava implements ViewModelProvider.Factory {

    private final OpenWeatherRepositoryRx openWeatherRepoRx;
    private final OpenWeatherJavaRepositoryRx openWeatherJavaRepositoryRx;

    public OpenWeatherViewModelFactoryJava(OpenWeatherRepositoryRx openWeatherRepoRx,
                                           OpenWeatherJavaRepositoryRx openWeatherJavaRepositoryRx ) {
            this.openWeatherRepoRx = openWeatherRepoRx;
            this.openWeatherJavaRepositoryRx = openWeatherJavaRepositoryRx;
        }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(OpenWeatherViewModelJava.class)) {
            return (T) new OpenWeatherViewModelJava(openWeatherRepoRx, openWeatherJavaRepositoryRx);
        }
        throw new IllegalArgumentException("Unknown model class $modelClass");
    }
}