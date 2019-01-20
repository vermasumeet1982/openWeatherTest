package com.test.openweathertest.dagger

import com.test.openweathertest.jv.fivedayforecast.FiveDayForecastFragmentJava
import com.test.openweathertest.jv.onedayforecast.OneDayForecastFragmentJava
import com.test.openweathertest.kt.fivedayforecast.FiveDayForecastFragment
import com.test.openweathertest.kt.onedayforecast.OneDayForecastFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindOneDayForecastFragment() : OneDayForecastFragment

    @ContributesAndroidInjector
    abstract fun bindFiveDayForecastFragment() : FiveDayForecastFragment

    @ContributesAndroidInjector
    abstract fun bindOneDayForecastFragmentJava() : OneDayForecastFragmentJava

    @ContributesAndroidInjector
    abstract fun bindFiveDayForecastFragmentJava() : FiveDayForecastFragmentJava
}