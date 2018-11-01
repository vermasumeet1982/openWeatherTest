package com.test.domain.openweather

import com.test.domain.openweather.networkmodel.Response
import retrofit2.Call

interface OpenWeatherRepositoryCr {

    fun getWeatherByDay(city : String) : Call<Response>

}