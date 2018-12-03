package com.test.openweathertest

import android.support.v4.app.Fragment

open abstract class ForecastFragment : Fragment() {

    abstract fun getTitle(): String

}