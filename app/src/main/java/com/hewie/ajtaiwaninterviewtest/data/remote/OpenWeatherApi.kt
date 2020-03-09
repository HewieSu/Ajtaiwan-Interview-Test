package com.hewie.ajtaiwaninterviewtest.data.remote

import com.hewie.ajtaiwaninterviewtest.data.structure.BaseResponseEntity
import com.hewie.ajtaiwaninterviewtest.data.structure.WeatherForecastEntity
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val version = "v1"

interface OpenWeatherApi {

    /**
     *  @author Hewie
     *  臺灣各縣市天氣預報資料及國際都市天氣預報
     *  @param Authorization 氣象開放資料平台會員授權碼 (Required)
     *  @param limit 限制最多回傳的資料, 預設為回傳全部筆數
     *  @param offset 指定從第幾筆後開始回傳, 預設為第 0 筆開始回傳
     *  @param format 回傳資料格式, 預設為 json 格式
     *  @param locationName 臺灣各縣市, 預設為回傳全部縣市
     *  @param elementName 天氣預報因子, 預設為全部回傳
     *  @param sort 同時對 「startTime」,「endTime」 做升冪排序, 預設不排序
     *  @param startTime 時間因子, 格式為「yyyy-MM-ddThh:mm:ss」, 預設為全部回傳
     *  @param timeFrom 時間區段, 篩選需要之時間區段，時間從「timeFrom」 開始篩選，直到內容之最後時間，並可與參數 「timeTo」 合併使用，格式為「yyyy-MM-ddThh:mm:ss」, 若使用參數「startTime」，則參數「timeFrom」的篩選資料則會失去作用, 預設為全部回傳
     *  @param timeTo 時間區段, 根據內容可篩選需要之時間區段，時間從內容之最初時間開始篩選，直到 「timeTo」，並可與參數 「timeFrom」 合併使用，格式為「yyyy-MM-ddThh:mm:ss」, 若使用「startTime」，則參數「timeTo」的篩選資料則會失效, 預設為全部回傳
     */
    @GET("/api/${version}/rest/datastore/F-C0032-001")
    fun f_c0032_001(@Query("Authorization") Authorization: String,
             @Query("limit") limit: String,
             @Query("offset") offset: String,
             @Query("format") format: String,
             @Query("locationName", encoded=true) locationName: ArrayList<String>,
             @Query("elementName") elementName: ArrayList<String>,
             @Query("sort") sort: String,
             @Query("startTime") startTime: ArrayList<String>,
             @Query("timeFrom") timeFrom: String,
             @Query("timeTo") timeTo: String): Observable<Response<BaseResponseEntity<WeatherForecastEntity>>>
}