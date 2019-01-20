package com.test.openweathertest.kt

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class ForecastFragment : Fragment() {

    abstract fun getTitle(): String

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}