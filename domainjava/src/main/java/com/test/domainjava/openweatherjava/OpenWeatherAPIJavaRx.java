package com.test.domainjava.openweatherjava;

import com.test.domainjava.openweatherjava.networkmodel.FiveDayForecastResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherAPIJavaRx {

    @GET("/data/2.5/forecast?")
    Observable<FiveDayForecastResponse> getWeatherForecast(@Query("q")String city , @Query("appid") String appId);

}