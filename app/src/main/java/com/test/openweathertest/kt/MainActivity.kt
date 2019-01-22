package com.test.openweathertest.kt

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.test.openweathertest.R
import com.test.openweathertest.jv.WeatherActivityJava
import com.test.openweathertest.kt.fivedayforecast.FiveDayForecastFragment
import com.test.openweathertest.kt.onedayforecast.OneDayForecastFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout.setupWithViewPager(viewpager)
        setupViewPager(viewpager)
        gotojava.setOnClickListener {
            val intent = Intent(this, WeatherActivityJava::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewPager(viewpager: ViewPager?) {
        val weatherViewPagerAdapter = WeatherViewPagerAdapter(supportFragmentManager)
        weatherViewPagerAdapter.addFragment(OneDayForecastFragment())
        weatherViewPagerAdapter.addFragment(FiveDayForecastFragment())
        viewpager?.adapter = weatherViewPagerAdapter
    }
}
