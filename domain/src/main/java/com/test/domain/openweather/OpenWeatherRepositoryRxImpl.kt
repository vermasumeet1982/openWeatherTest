package com.test.domain.openweather

import android.content.Context
import com.test.domain.R
import com.test.domain.openweather.networkmodel.Response
import io.reactivex.Observable

class OpenWeatherRepositoryRxImpl(val context: Context, val openWeatherAPI: OpenWeatherAPIRx) : OpenWeatherRepositoryRx  {


//    override fun getWeatherForecast(city: String) {
//        openWeatherAPI.getWeatherForecast(city)
//    }

    override fun getWeatherByDay(city: String): Observable<Response> {
        val appId = context.resources.getString(R.string.app_id)
        return openWeatherAPI.getWeatherByDay(city, appId)
    }
}