package com.hewie.ajtaiwaninterviewtest.config

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

const val OPEN_DATA_AUTH = "CWB-E08F71DA-C71B-4587-AD1F-4DF7DFB7EBFC"

enum class ENV {
    ALPHA, BETA, PROD
}

// region APIHOST
abstract class ApiHost {
    // 依平台自行定義
    abstract val API_RESTFUL: String
}

object AlphaHost: ApiHost() {
    override val API_RESTFUL = "https://opendata.cwb.gov.tw"
}

object BetaHost: ApiHost() {
    override val API_RESTFUL = ""
}

object ProdHost: ApiHost() {
    override val API_RESTFUL = ""
}
// endregion

// KEYPOINT host
fun host(env: ENV = ENV.ALPHA): ApiHost {
    when(env) {
        ENV.ALPHA -> return AlphaHost
        ENV.BETA -> return BetaHost
        ENV.PROD -> return ProdHost
    }
}

class ApiSetter {
    private val loglevel = HttpLoggingInterceptor.Level.BODY

    fun newOKHttpclient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor()).build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = ApiSetter().loglevel
        return interceptor
    }
}