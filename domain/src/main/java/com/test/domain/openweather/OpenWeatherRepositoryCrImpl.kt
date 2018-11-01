package com.test.domain.openweather

import android.content.Context
import com.test.domain.R
import com.test.domain.openweather.networkmodel.Response
import retrofit2.Call

class OpenWeatherRepositoryCrImpl(val context: Context, val openWeatherAPI: OpenWeatherAPI) : OpenWeatherRepositoryCr  {


//    override fun getWeatherForecast(city: String) {
//        openWeatherAPI.getWeatherForecast(city)
//    }

    override fun getWeatherByDay(city: String): Call<Response> {
        val appId = context.resources.getString(R.string.app_id)
        return openWeatherAPI.getWeatherByDay(city, appId)
    }
}