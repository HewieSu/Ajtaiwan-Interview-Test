package com.hewie.ajtaiwaninterviewtest.data.remote.repository

import com.hewie.ajtaiwaninterviewtest.data.remote.OpenWeatherApi
import com.hewie.ajtaiwaninterviewtest.data.structure.BaseResponseEntity
import com.hewie.ajtaiwaninterviewtest.data.structure.WeatherForecastEntity
import com.hewie.ajtaiwaninterviewtest.params.WeatherForecastParams
import com.hewie.ajtaiwaninterviewtest.util.ApiUtil
import io.reactivex.Observable
import retrofit2.Response

class OpenWeatherRepository {
    private val open_weather_api = ApiUtil.retrofit(api = OpenWeatherApi::class.java)

    fun f_c0032_001(params: WeatherForecastParams):
            Observable<Response<BaseResponseEntity<WeatherForecastEntity>>> =
        open_weather_api.f_c0032_001(
            params.Authorization,
            params.limit,
            params.offset,
            params.format,
            params.locationName,
            params.elementName,
            params.sort,
            params.startTime,
            params.timeFrom,
            params.timeTo)
}