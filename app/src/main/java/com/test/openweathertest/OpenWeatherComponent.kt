package com.test.openweathertest

import com.test.domain.dagger.OpenWeatherModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MainModule::class, OpenWeatherModule::class, ActivityModule::class, OpenWeatherAppModule::class, FragmentModule::class))
interface OpenWeatherComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: OpenWeatherApplication) : Builder

        fun mainModule(mainModule : MainModule) : Builder

        fun build() : OpenWeatherComponent
    }

    fun inject(app: OpenWeatherApplication)
}