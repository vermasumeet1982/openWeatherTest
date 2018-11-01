package com.test.domain.openweather

import com.test.domain.openweather.networkmodel.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPIRx {

    @GET("/data/2.5/weather?")
    fun getWeatherByDay(@Query("q")city : String, @Query("appid") appId: String) : Observable<Response>

}