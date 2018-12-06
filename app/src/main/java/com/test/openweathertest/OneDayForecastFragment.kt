package com.test.openweathertest

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.domain.openweather.networkmodel.Response
import kotlinx.android.synthetic.main.fragment_one_day_forecast.*
import javax.inject.Inject

class OneDayForecastFragment : ForecastFragment() {

    @Inject
    lateinit var openWeatherViewModelFactory:OpenWeatherViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one_day_forecast, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val openWeatherViewModel = ViewModelProviders.of(this, openWeatherViewModelFactory).get(OpenWeatherViewModel::class.java)

        openWeatherViewModel.result.observe(this, Observer<Response> { response -> handleSuccess(response)})
        openWeatherViewModel.error.observe(this, Observer<Throwable> {error -> handleError(error)})

        openWeatherViewModel.getWeatherForTheDay("Orpington")
    }

    override fun getTitle(): String {
        return "1 day"
    }

    fun handleSuccess(response: Response?) {
        Log.d(MainActivity.TAG, response.toString())
        city.text = getString(R.string.city_forecast, "Orpington")
        oneDayWeather.text = response?.weather?.get(0)?.description

    }

    fun handleError(error: Throwable?) {
        Log.d(MainActivity.TAG, error?.message)
    }
}