package com.test.openweathertest.jv;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class WeatherViewPagerAdapterJava extends FragmentPagerAdapter {


    private List<ForecastFragmentJava> fragmentList;
    public WeatherViewPagerAdapterJava(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getTitle();
    }

    public void addFragment(ForecastFragmentJava forecastFragment) {
        fragmentList.add(forecastFragment);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }
}