package com.test.domainjava.openweatherjava;

import com.test.domainjava.openweatherjava.networkmodel.FiveDayForecastResponse;

import io.reactivex.Observable;

public interface OpenWeatherJavaRepositoryRx {

    Observable<FiveDayForecastResponse> getWeatherForecast(String city );

}