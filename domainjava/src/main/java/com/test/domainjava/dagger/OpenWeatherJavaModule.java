package com.test.domainjava.dagger;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.test.domainjava.openweatherjava.OpenWeatherAPIJavaRx;
import com.test.domainjava.openweatherjava.OpenWeatherJavaAPI;
import com.test.domainjava.openweatherjava.OpenWeatherJavaRepositoryRx;
import com.test.domainjava.openweatherjava.OpenWeatherJavaRepositoryRxImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class OpenWeatherJavaModule {


    @Provides
    @Singleton
    public OpenWeatherJavaAPI provideOpenWeatherJavaAPI() {
        final String baseUrl = "https://api.openweathermap.org";
        final OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.addInterceptor(new HttpLoggingInterceptor());
        final Retrofit retrofit = new Retrofit.Builder().client(okhttpClientBuilder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .build();
        return retrofit.create(OpenWeatherJavaAPI.class);

    }

    @Provides
    @Singleton
    public OpenWeatherAPIJavaRx provideOpenWeatherAPIRx() {
        final String baseUrl = "https://api.openweathermap.org";
        final OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpClientBuilder.addInterceptor(httpLoggingInterceptor);
        final Retrofit retrofit = new Retrofit.Builder().client(okhttpClientBuilder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(OpenWeatherAPIJavaRx.class);

    }


    @Provides
    @Singleton
    public OpenWeatherJavaRepositoryRx provideOpenWeatherRepositoryRx(Context context, OpenWeatherAPIJavaRx openWeatherAPI)  {

        return new OpenWeatherJavaRepositoryRxImpl(context, openWeatherAPI);
    }

}