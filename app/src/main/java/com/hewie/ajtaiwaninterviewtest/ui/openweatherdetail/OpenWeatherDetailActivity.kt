package com.hewie.ajtaiwaninterviewtest.ui.openweatherdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hewie.ajtaiwaninterviewtest.R
import com.hewie.ajtaiwaninterviewtest.data.structure.TimeEntity
import com.hewie.ajtaiwaninterviewtest.defined.BUNDLE_TIME
import kotlinx.android.synthetic.main.activity_open_weather_detail.*

class OpenWeatherDetailActivity: AppCompatActivity(), OpenWeatherDetailPresenter.Views {

    private val mTimeEntity: TimeEntity? by lazy { intent?.extras?.getSerializable(BUNDLE_TIME) as TimeEntity }
    private val presenter = OpenWeatherDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_weather_detail)

        loadDatas()
    }

    private fun loadDatas() {
        mTimeEntity?.let {
            tvStartTime.text = it.startTime
            tvEndTime.text = it.endTime
            tvParameterName.text = it.parameter.parameterName
            tvParameterUnit.text = it.parameter.parameterUnit
        }
    }
}