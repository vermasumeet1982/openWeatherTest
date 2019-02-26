package com.test.openweathertest.jv.onedayforecast;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.domain.openweather.networkmodel.Response;
import com.test.openweathertest.R;
import com.test.openweathertest.jv.ForecastFragmentJava;
import com.test.openweathertest.jv.OpenWeatherViewModelFactoryJava;
import com.test.openweathertest.jv.OpenWeatherViewModelJava;

import javax.inject.Inject;


public class OneDayForecastFragmentJava extends ForecastFragmentJava {

    @Inject
    OpenWeatherViewModelFactoryJava openWeatherViewModelFactoryJava;

    private static final String TAG = OneDayForecastFragmentJava.class.getSimpleName();

    private TextView city;
    private TextView oneDayWeather;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_one_day_forecast, container, false);
        city = view.findViewById(R.id.city);
        oneDayWeather = view.findViewById(R.id.oneDayWeather);
        final ImageView icon = view.findViewById(R.id.icon);
        icon.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_kotlin2));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        OpenWeatherViewModelJava openWeatherViewModel = ViewModelProviders.of(this, openWeatherViewModelFactoryJava).get(OpenWeatherViewModelJava.class);

        openWeatherViewModel.getResult().observe(this, this::handleSuccess);
        openWeatherViewModel.getError().observe(this, this::handleError);

        openWeatherViewModel.getWeatherForTheDay(CITY);
    }

    @Override
    public String getTitle() {
        return "1 day";
    }

    public void handleSuccess(Response response) {
        Log.d(TAG, response.toString());
        city.setText(getString(R.string.city_weather, CITY));
        if(response.getWeather()!= null && response.getWeather().get(0) != null) {
            oneDayWeather.setText(response.getWeather().get(0).getDescription());
        }
    }

    public void handleError(Throwable error) {
        Log.e(TAG, error.getMessage());
    }
}