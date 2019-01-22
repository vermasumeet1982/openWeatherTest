package com.test.openweathertest.jv;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.test.domain.openweather.OpenWeatherRepositoryRx;
import com.test.domain.openweather.networkmodel.Response;
import com.test.domainjava.openweatherjava.OpenWeatherJavaRepositoryRx;
import com.test.domainjava.openweatherjava.networkmodel.FiveDayForecastResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OpenWeatherViewModelJava extends ViewModel {

    private final OpenWeatherRepositoryRx openWeatherRepositoryRx;

    private final OpenWeatherJavaRepositoryRx openWeatherJavaRepositoryRx;

    private MutableLiveData<Response> result = new MutableLiveData<>();



    private MutableLiveData<FiveDayForecastResponse> forecast = new MutableLiveData<>();

    MutableLiveData<Throwable> error = new MutableLiveData<>();

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public OpenWeatherViewModelJava(OpenWeatherRepositoryRx openWeatherRepositoryRx, OpenWeatherJavaRepositoryRx openWeatherJavaRepositoryRx) {
        this.openWeatherRepositoryRx = openWeatherRepositoryRx;
        this.openWeatherJavaRepositoryRx = openWeatherJavaRepositoryRx;
    }


    public void getWeatherForTheDay(final String city) {
        Disposable disposable = openWeatherRepositoryRx.getWeatherByDay(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError);
        compositeDisposable.add(disposable);
    }


    public void getWeatherForecast(final String city) {
        Disposable disposable = openWeatherJavaRepositoryRx.getWeatherForecast(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleForecastResponse, this::handleError);
        compositeDisposable.add(disposable);
    }

    public MutableLiveData<FiveDayForecastResponse> getForecast() {
        return forecast;
    }

    public MutableLiveData<Throwable> getError() {
        return error;
    }

    public MutableLiveData<Response> getResult() {
        return result;
    }

    private void handleResponse(final Response response) {
        result.postValue(response);
    }

    private void handleForecastResponse(final FiveDayForecastResponse response) {
        forecast.postValue(response);
    }

    private void handleError(final Throwable throwable) {
        error.postValue(throwable);
    }


}
