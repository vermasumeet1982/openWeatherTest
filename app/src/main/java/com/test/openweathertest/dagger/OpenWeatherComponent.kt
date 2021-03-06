package com.test.openweathertest.dagger

import com.test.domain.dagger.OpenWeatherModule
import com.test.domainjava.dagger.OpenWeatherJavaModule
import com.test.openweathertest.OpenWeatherApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MainModule::class, OpenWeatherModule::class, ActivityModule::class,
        OpenWeatherAppModule::class, FragmentModule::class, OpenWeatherJavaModule::class, OpenWeatherAppModuleJava::class))
interface OpenWeatherComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: OpenWeatherApplication): Builder

        fun mainModule(mainModule: MainModule): Builder

        fun build(): OpenWeatherComponent
    }

    fun inject(app: OpenWeatherApplication)
}