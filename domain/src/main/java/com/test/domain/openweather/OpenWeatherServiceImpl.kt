package com.test.domain.openweather

import com.test.domain.openweather.networkmodel.Response
import io.reactivex.Observable

class OpenWeatherServiceImpl(val openWeatherAPI: OpenWeatherAPI) : OpenWeatherService  {


//    override fun getWeatherForecast(city: String) {
//        openWeatherAPI.getWeatherForecast(city)
//    }

    override fun getWeatherByDay(city: String): Observable<Response> {
        return openWeatherAPI.getWeatherByDay(city)
    }
}