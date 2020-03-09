package com.hewie.ajtaiwaninterviewtest.data.structure

import java.io.Serializable

class TimeEntity: Serializable{
    var startTime: String = ""
    var endTime: String = ""
    var parameter: ParameterEntity = ParameterEntity()
}