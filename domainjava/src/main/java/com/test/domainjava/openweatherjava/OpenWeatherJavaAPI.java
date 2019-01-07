package com.test.domainjava.openweatherjava;

import com.test.domainjava.openweatherjava.networkmodel.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherJavaAPI {

    @GET("/data/2.5/weather?")
    Call<Response> getWeatherByDay(@Query("q")String city, @Query("appid") String appId);

}