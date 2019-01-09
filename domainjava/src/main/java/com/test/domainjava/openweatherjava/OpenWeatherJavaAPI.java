package com.test.domainjava.openweatherjava;

import com.test.domainjava.openweatherjava.networkmodel.FiveDayForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherJavaAPI {

    @GET("/data/2.5/forecast?")
    Call<FiveDayForecastResponse> getWeatherForecast(@Query("q")String city, @Query("appid") String appId);

}