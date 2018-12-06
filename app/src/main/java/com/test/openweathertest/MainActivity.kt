package com.test.openweathertest

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout.setupWithViewPager(viewpager)
        setupViewPager(viewpager)
    }

    private fun setupViewPager(viewpager: ViewPager?) {
        val weatherViewPagerAdapter = WeatherViewPagerAdapter(supportFragmentManager)
        weatherViewPagerAdapter.addFragment(OneDayForecastFragment())
        weatherViewPagerAdapter.addFragment(FiveDayForecastFragment())
        viewpager?.adapter = weatherViewPagerAdapter
    }
}
