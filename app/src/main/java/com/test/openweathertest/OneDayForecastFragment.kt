package com.test.openweathertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class OneDayForecastFragment : ForecastFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one_day_forecast, container, false)
    }

    override fun getTitle(): String {
        return "1 day"
    }
}