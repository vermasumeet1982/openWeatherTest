package com.test.openweathertest

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.test.domain.openweather.OpenWeatherRepositoryRx

@Suppress("UNCHECKED_CAST")
class OpenWeatherViewModelFactory (val openWeatherRepoRx: OpenWeatherRepositoryRx) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(OpenWeatherViewModel::class.java)) {
            return OpenWeatherViewModel(openWeatherRepoRx) as T
        }
        throw IllegalArgumentException("Unknown model class $modelClass")
    }

}