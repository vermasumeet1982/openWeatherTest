package com.test.openweathertest

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class OpenWeatherApplication : Application(), HasActivityInjector {


    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        DaggerOpenWeatherComponent.builder()
                .application(this)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}