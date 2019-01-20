package com.test.openweathertest.kt

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.domain.openweather.OpenWeatherRepositoryRx
import com.test.domain.openweather.networkmodel.Response
import com.test.domainjava.openweatherjava.OpenWeatherJavaRepositoryRx
import com.test.domainjava.openweatherjava.networkmodel.FiveDayForecastResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class OpenWeatherViewModel(val openWeatherRepositoryRx: OpenWeatherRepositoryRx, val openWeatherJavaRepositoryRx: OpenWeatherJavaRepositoryRx) : ViewModel() {
    val result: MutableLiveData<Response> = MutableLiveData()

    val forecast: MutableLiveData<FiveDayForecastResponse> = MutableLiveData()

    val error: MutableLiveData<Throwable> = MutableLiveData()

    val compositeDisposable : CompositeDisposable = CompositeDisposable()

    fun getWeatherForTheDay(city : String) {
        openWeatherRepositoryRx.getWeatherByDay(city)
                .subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({handleResponse(it)}, {handleError(it)})
                ?.let { compositeDisposable.add(it) }
    }

    fun getWeatherForecast(city : String) {
        openWeatherJavaRepositoryRx.getWeatherForecast(city)
                .subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({handleForecastResponse(it)}, {handleError(it)})
                ?.let { compositeDisposable.add(it) }
    }

    fun handleResponse(response: Response) {
        result.value = (response)
    }

    fun handleForecastResponse(response: FiveDayForecastResponse) {
        forecast.value = (response)
    }

    fun handleError(throwable: Throwable) {
        error.value = throwable
    }


}
