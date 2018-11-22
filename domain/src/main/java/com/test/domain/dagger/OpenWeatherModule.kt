package com.test.domain.dagger

import android.content.Context
import com.google.gson.GsonBuilder
import com.test.domain.openweather.*
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class OpenWeatherModule {


    @Provides
    @Singleton
    fun provideOpenWeatherAPI(): OpenWeatherAPI {
        val baseUrl = "https://api.openweathermap.org"
        val okhttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okhttpClientBuilder.addInterceptor(HttpLoggingInterceptor())
        val retrofit: Retrofit = Retrofit.Builder().client(okhttpClientBuilder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
                .build()
        return retrofit.create(OpenWeatherAPI::class.java)

    }

    @Provides
    @Singleton
    fun provideOpenWeatherAPIRx(): OpenWeatherAPIRx {
        val baseUrl = "https://api.openweathermap.org"
        val okhttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okhttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        val retrofit: Retrofit = Retrofit.Builder().client(okhttpClientBuilder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(OpenWeatherAPIRx::class.java)

    }

    @Provides
    @Singleton
    fun provideOpenWeatherRepositoryCR(context: Context, openWeatherAPI: OpenWeatherAPI): OpenWeatherRepositoryCr {

        return OpenWeatherRepositoryCrImpl(context, openWeatherAPI)
    }

    @Provides
    @Singleton
    fun provideOpenWeatherRepositoryRx(context: Context, openWeatherAPI: OpenWeatherAPIRx): OpenWeatherRepositoryRx {

        return OpenWeatherRepositoryRxImpl(context, openWeatherAPI)
    }

}