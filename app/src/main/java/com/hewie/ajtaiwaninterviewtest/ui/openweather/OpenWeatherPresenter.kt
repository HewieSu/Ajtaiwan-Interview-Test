package com.hewie.ajtaiwaninterviewtest.ui.openweather

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.hewie.ajtaiwaninterviewtest.BR
import com.hewie.ajtaiwaninterviewtest.params.WeatherForecastParams

class OpenWeatherPresenter(private val views: Views) {

    private val viewmodel = OpenWeatherViewModel(views as LifecycleOwner)

    fun setViewBinding(binding: ViewDataBinding) {
        binding.setVariable(BR.vm, viewmodel)
    }

    fun loadWeatherForecast(params: WeatherForecastParams) {
        viewmodel.f_c0032_001(params) { entity ->
            entity?.let {
                val data = ArrayList<Any>()
                it.location.map { locations ->
                    locations.weatherElement.map { weather ->
                        weather.time.map { time ->
                            data.add(time)
                            data.add(ITEM_TYPE_WEATHER_UNDEFINED)
                        }
                    }
                }
                views.loadDatas(data)
            }
        }
    }

    interface Views {
        fun loadDatas(data: ArrayList<Any>)
    }
}