package com.test.domain.openweather

import com.test.domain.openweather.networkmodel.Response
import io.reactivex.Observable

interface OpenWeatherRepositoryRx {

    fun getWeatherByDay(city : String) : Observable<Response>

}