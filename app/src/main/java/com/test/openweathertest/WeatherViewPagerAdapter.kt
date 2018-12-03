package com.test.openweathertest

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class WeatherViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val fragmentList: MutableList<ForecastFragment> = mutableListOf()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(p0: Int): ForecastFragment {
        return fragmentList[p0]
    }

    fun addFragment(fragment: ForecastFragment) {
        fragmentList.add(fragment)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentList[position].getTitle()
    }

}