package com.hewie.ajtaiwaninterviewtest.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.hewie.ajtaiwaninterviewtest.R

class WeatherDataView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle) {

    init {
        addView(LayoutInflater.from(context).inflate(R.layout.item_weather_data, null))
    }
}