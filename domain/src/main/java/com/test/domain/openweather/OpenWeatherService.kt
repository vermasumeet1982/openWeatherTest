package com.test.domain.openweather

import com.test.domain.openweather.networkmodel.Response
import io.reactivex.Observable

interface OpenWeatherService {

    fun getWeatherByDay(city : String) : Observable<Response>

//    fun getWeatherForecast(city: String)

}