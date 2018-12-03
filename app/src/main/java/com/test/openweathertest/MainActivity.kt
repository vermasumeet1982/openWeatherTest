package com.test.openweathertest

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.test.domain.openweather.networkmodel.Response
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
    @Inject
    lateinit var openWeatherViewModelFactory:OpenWeatherViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout.setupWithViewPager(viewpager)
        setupViewPager(viewpager)
        val openWeatherViewModel = ViewModelProviders.of(this, openWeatherViewModelFactory).get(OpenWeatherViewModel::class.java)

        openWeatherViewModel.result.observe(this, Observer<Response> {response -> handleSuccess(response)})
        openWeatherViewModel.error.observe(this, Observer<Throwable> {error -> handleError(error)})

        openWeatherViewModel.getWeatherForTheDay("Orpington")

    }

    private fun setupViewPager(viewpager: ViewPager?) {
        val weatherViewPagerAdapter = WeatherViewPagerAdapter(supportFragmentManager)
        weatherViewPagerAdapter.addFragment(OneDayForecastFragment())
        weatherViewPagerAdapter.addFragment(FiveDayForecastFragment())
        viewpager?.adapter = weatherViewPagerAdapter
    }

    fun handleSuccess(response: Response?) {
        Log.d(TAG, response.toString())

    }

    fun handleError(error: Throwable?) {
        Log.d(TAG, error?.message)
    }
}
