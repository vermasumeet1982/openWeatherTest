package com.test.openweathertest.jv.onedayforecast;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.domain.openweather.networkmodel.Response;
import com.test.openweathertest.R;
import com.test.openweathertest.kt.OpenWeatherViewModel;
import com.test.openweathertest.kt.OpenWeatherViewModelFactory;
import com.test.openweathertest.jv.*;

import javax.inject.Inject;


public class OneDayForecastFragmentJava extends ForecastFragmentJava {

    @Inject
    OpenWeatherViewModelFactory openWeatherViewModelFactory;

    private static final String TAG = OneDayForecastFragmentJava.class.getSimpleName();

    private TextView city;
    private TextView oneDayWeather;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_one_day_forecast, container, false);
        city = view.findViewById(R.id.city);
        oneDayWeather = view.findViewById(R.id.oneDayWeather);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        OpenWeatherViewModel openWeatherViewModel = ViewModelProviders.of(this, openWeatherViewModelFactory).get(OpenWeatherViewModel.class);

        openWeatherViewModel.getResult().observe(this, this::handleSuccess);
        openWeatherViewModel.getError().observe(this, this::handleError);

        openWeatherViewModel.getWeatherForTheDay("Orpington");
    }

    @Override
    public String getTitle() {
        return "1 day";
    }

    public void handleSuccess(Response response) {
        Log.d(TAG, response.toString());
        city.setText(getString(R.string.city_forecast, "Orpington"));
        if(response != null && response.getWeather()!= null && response.getWeather().get(0) != null) {
            oneDayWeather.setText(response.getWeather().get(0).getDescription());
        }
    }

    public void handleError(Throwable error) {
        Log.e(TAG, error.getMessage());
    }
}