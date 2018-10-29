package com.test.domain.dagger

import android.content.Context
import com.google.gson.GsonBuilder
import com.test.domain.openweather.OpenWeatherAPI
import com.test.domain.openweather.OpenWeatherService
import com.test.domain.openweather.OpenWeatherServiceImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class OpenWeatherModule {


    @Provides @Singleton fun provideOpenWeatherAPI() : OpenWeatherAPI {
        val baseUrl = "https://api.openweathermap.org"
        val okhttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okhttpClientBuilder.addInterceptor(HttpLoggingInterceptor())
        val retrofit : Retrofit = Retrofit.Builder().client(okhttpClientBuilder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
                .build()
        return retrofit.create(OpenWeatherAPI::class.java)

    }

    @Provides @Singleton fun provideOpenWeatherService(context: Context ,openWeatherAPI: OpenWeatherAPI) : OpenWeatherService {

        return OpenWeatherServiceImpl(context, openWeatherAPI)
    }
}