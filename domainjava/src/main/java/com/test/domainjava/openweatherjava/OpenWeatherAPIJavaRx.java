package com.test.domainjava.openweatherjava;

import com.test.domainjava.openweatherjava.networkmodel.Response;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherAPIJavaRx {

    @GET("/data/2.5/weather?")
    Observable<Response> getWeatherByDay(@Query("q")String city , @Query("appid") String appId);

}