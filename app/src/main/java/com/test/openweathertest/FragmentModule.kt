package com.test.openweathertest

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindOneDayForecastFragment() : OneDayForecastFragment

    @ContributesAndroidInjector
    abstract fun bindFiveDayForecastFragment() : FiveDayForecastFragment
}