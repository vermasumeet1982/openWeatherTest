package com.test.domainjava.openweatherjava;

import android.content.Context;
import com.test.domainjava.R;
import com.test.domainjava.openweatherjava.networkmodel.Response;
import io.reactivex.Observable;

public class OpenWeatherJavaRepositoryRxImpl implements OpenWeatherJavaRepositoryRx  {

    private  Context context;
    private  OpenWeatherAPIJavaRx openWeatherAPIJavaRx;

    public OpenWeatherJavaRepositoryRxImpl(Context context, OpenWeatherAPIJavaRx openWeatherAPIJavaRx) {
        this.context = context;
        this.openWeatherAPIJavaRx = openWeatherAPIJavaRx;
    }


    @Override
    public Observable<Response> getWeatherByDay(String city) {
        String appId = context.getResources().getString(R.string.app_id);
        return openWeatherAPIJavaRx.getWeatherByDay(city, appId);
    }
}