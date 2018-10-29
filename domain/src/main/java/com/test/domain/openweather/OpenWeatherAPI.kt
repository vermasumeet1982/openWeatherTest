package com.test.domain.openweather

import com.test.domain.openweather.networkmodel.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {

    @GET("/data/2.5/weather?")
    fun getWeatherByDay(@Query("q")city : String, @Query("appid") appId: String) : Call<Response>

}