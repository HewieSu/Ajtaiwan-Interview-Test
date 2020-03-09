package com.hewie.ajtaiwaninterviewtest.params

import com.hewie.ajtaiwaninterviewtest.config.OPEN_DATA_AUTH

class WeatherForecastParams {
    var Authorization: String = OPEN_DATA_AUTH
    var limit: String = ""
    var offset: String = ""
    var format: String = ""
    var locationName: ArrayList<String> = ArrayList()
    var elementName: ArrayList<String> = ArrayList()
    var sort: String = ""
    var startTime: ArrayList<String> = ArrayList()
    var timeFrom: String = ""
    var timeTo: String = ""
}