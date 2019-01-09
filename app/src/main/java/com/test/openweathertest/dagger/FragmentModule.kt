package com.test.openweathertest.dagger

import com.test.openweathertest.fivedayforecast.FiveDayForecastFragment
import com.test.openweathertest.onedayforecast.OneDayForecastFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindOneDayForecastFragment() : OneDayForecastFragment

    @ContributesAndroidInjector
    abstract fun bindFiveDayForecastFragment() : FiveDayForecastFragment
}