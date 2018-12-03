package com.test.openweathertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FiveDayForecastFragment : ForecastFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_five_day_forecast, container, false)
        return view
    }

    override fun getTitle(): String {
        return "5 day"
    }

}