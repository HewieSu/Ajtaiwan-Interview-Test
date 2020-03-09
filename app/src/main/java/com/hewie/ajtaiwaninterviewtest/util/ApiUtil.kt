package com.hewie.ajtaiwaninterviewtest.util

import com.google.gson.GsonBuilder
import com.hewie.ajtaiwaninterviewtest.config.ApiSetter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.hewie.ajtaiwaninterviewtest.config.host

object ApiUtil {
    private val gsonBuilder = GsonBuilder().apply {
        serializeNulls()
    }.create()

    fun <T> retrofit(host: String = host().API_RESTFUL, api: Class<T>, apisetter: ApiSetter = ApiSetter()): T {
        return Retrofit.Builder().apply {
            baseUrl(host)
            client(apisetter.newOKHttpclient())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create(gsonBuilder))
        }.build().create(api)
    }
}