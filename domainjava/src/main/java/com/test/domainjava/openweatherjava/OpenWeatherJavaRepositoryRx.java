package com.test.domainjava.openweatherjava;

import com.test.domainjava.openweatherjava.networkmodel.Response;
import io.reactivex.Observable;

public interface OpenWeatherJavaRepositoryRx {

    Observable<Response> getWeatherByDay(String city );

}