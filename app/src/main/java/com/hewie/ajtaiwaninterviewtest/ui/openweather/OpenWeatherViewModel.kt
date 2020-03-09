package com.hewie.ajtaiwaninterviewtest.ui.openweather

import androidx.lifecycle.LifecycleOwner
import com.hewie.ajtaiwaninterviewtest.common.BaseViewModel
import com.hewie.ajtaiwaninterviewtest.data.remote.repository.OpenWeatherRepository
import com.hewie.ajtaiwaninterviewtest.data.structure.WeatherForecastEntity
import com.hewie.ajtaiwaninterviewtest.params.WeatherForecastParams
import com.hewie.ajtaiwaninterviewtest.util.async
import com.hewie.ajtaiwaninterviewtest.util.bindLifeCycle
import io.reactivex.rxkotlin.subscribeBy

class OpenWeatherViewModel(private val lifecycleOwner: LifecycleOwner): BaseViewModel() {
    private val repository = OpenWeatherRepository()

    fun f_c0032_001(params: WeatherForecastParams, callback: (WeatherForecastEntity?) -> Unit) =
        repository.f_c0032_001(params).async().apply {
            bindLifeCycle(lifecycleOwner)
            startLoading()
        }.subscribeBy (
            onNext = {
                if(it.isSuccessful) { callback(it.body()?.records) } else {}
            },
            onError = {
                it.printStackTrace()
                stopLoading()
            },
            onComplete = { stopLoading() }
        )
}