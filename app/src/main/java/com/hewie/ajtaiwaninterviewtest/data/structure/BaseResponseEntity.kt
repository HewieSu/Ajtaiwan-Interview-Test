package com.hewie.ajtaiwaninterviewtest.data.structure

import com.google.gson.annotations.Expose

open class BaseResponseEntity<T> {
    var success: Boolean = false
    var result: ResultEntity = ResultEntity()

    @Expose
    var records: T? = null
}