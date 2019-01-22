package com.test.openweathertest.jv.fivedayforecast;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.domainjava.openweatherjava.networkmodel.FiveDayForecastResponse;
import com.test.openweathertest.R;
import com.test.openweathertest.jv.ForecastFragmentJava;
import com.test.openweathertest.jv.OpenWeatherViewModelFactoryJava;
import com.test.openweathertest.jv.OpenWeatherViewModelJava;

import javax.inject.Inject;

public class FiveDayForecastFragmentJava extends ForecastFragmentJava {

    private static final String TAG = FiveDayForecastFragmentJava.class.getSimpleName();

    @Inject
    OpenWeatherViewModelFactoryJava openWeatherViewModelFactoryJava;

    WeatherListAdapterJava weatherListAdapter = new WeatherListAdapterJava();

    private TextView city;

    private RecyclerView weather_forecast_list;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View  view = inflater.inflate(R.layout.fragment_five_day_forecast, container, false);
        city = view.findViewById(R.id.city);
        weather_forecast_list = view.findViewById(R.id.weather_forecast_list);
        final ImageView icon = view.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.ic_kotlin2);
        return view;
    }

    @Override
    public String getTitle() {
        return "5 day";
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        final OpenWeatherViewModelJava openWeatherViewModel = ViewModelProviders.of(this, openWeatherViewModelFactoryJava).get(OpenWeatherViewModelJava.class);
        openWeatherViewModel.getForecast().observe(this, this::handleSuccess);
        openWeatherViewModel.getError().observe(this, this::handleError);

        openWeatherViewModel.getWeatherForecast("Orpington");

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(weather_forecast_list  != null) {
            weather_forecast_list.setLayoutManager(new LinearLayoutManager(getActivity()));
            weather_forecast_list.setAdapter(weatherListAdapter);
        }

    }

    public void handleSuccess(FiveDayForecastResponse response) {
        Log.d(TAG, response.toString());
        city.setText(getString(R.string.city_forecast, "Orpington"));
            weatherListAdapter.setData(response.getList());
    }

    public void handleError(Throwable error) {
        if(error != null && error.getMessage() != null) {
            Log.e(TAG, error.getMessage());
        }
    }

}