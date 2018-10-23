package com.test.domain.openweather

import com.test.domain.openweather.networkmodel.Response
import io.reactivex.Observable

class OpenWeatherAPIImpl : OpenWeatherAPI {


    override fun getWeatherForecast(city: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWeatherByDay(city: String): Observable<Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}