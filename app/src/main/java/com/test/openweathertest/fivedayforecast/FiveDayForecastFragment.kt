package com.test.openweathertest.fivedayforecast

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.domainjava.openweatherjava.networkmodel.FiveDayForecastResponse
import com.test.openweathertest.ForecastFragment
import com.test.openweathertest.OpenWeatherViewModel
import com.test.openweathertest.OpenWeatherViewModelFactory
import com.test.openweathertest.R
import kotlinx.android.synthetic.main.fragment_five_day_forecast.*
import javax.inject.Inject

class FiveDayForecastFragment : ForecastFragment() {

    companion object {
        val TAG = FiveDayForecastFragment::class.java.simpleName
    }

    @Inject
    lateinit var openWeatherViewModelFactory: OpenWeatherViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_five_day_forecast, container, false)
        return view
    }

    override fun getTitle(): String {
        return "5 day"
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val openWeatherViewModel = ViewModelProviders.of(this, openWeatherViewModelFactory).get(OpenWeatherViewModel::class.java)

        openWeatherViewModel.forecast.observe(this, Observer<FiveDayForecastResponse> { response -> handleSuccess(response)})
        openWeatherViewModel.error.observe(this, Observer<Throwable> {error -> handleError(error)})

        openWeatherViewModel.getWeatherForecast("Orpington")
    }

    fun handleSuccess(response: FiveDayForecastResponse?) {
        Log.d(TAG, response.toString())
        city.text = getString(R.string.city_forecast, "Orpington")
//        oneDayWeather.text = response?.weather?.get(0)?.description

    }

    fun handleError(error: Throwable?) {
        Log.e(TAG, error?.message)
    }

}