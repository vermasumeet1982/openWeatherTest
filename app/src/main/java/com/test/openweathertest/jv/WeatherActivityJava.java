package com.test.openweathertest.jv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.test.openweathertest.R;
import com.test.openweathertest.jv.fivedayforecast.FiveDayForecastFragmentJava;
import com.test.openweathertest.jv.onedayforecast.OneDayForecastFragmentJava;

import dagger.android.AndroidInjection;

public class WeatherActivityJava extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabLayout tabLayout = findViewById(R.id.tablayout);
        final ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        WeatherViewPagerAdapterJava weatherViewPagerAdapter = new WeatherViewPagerAdapterJava(getSupportFragmentManager());
        weatherViewPagerAdapter.addFragment(new OneDayForecastFragmentJava());
        weatherViewPagerAdapter.addFragment(new FiveDayForecastFragmentJava());
        viewPager.setAdapter(weatherViewPagerAdapter);
//        viewpager?.adapter = weatherViewPagerAdapter
    }
}
