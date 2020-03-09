package com.hewie.ajtaiwaninterviewtest.ui.openweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hewie.ajtaiwaninterviewtest.R
import com.hewie.ajtaiwaninterviewtest.data.structure.TimeEntity
import com.hewie.ajtaiwaninterviewtest.defined.BUNDLE_TIME
import com.hewie.ajtaiwaninterviewtest.ui.openweatherdetail.OpenWeatherDetailActivity
import com.hewie.ajtaiwaninterviewtest.util.loadActivityWithBundle

const val ITEM_TYPE_WEATHER_UNDEFINED = 0
const val ITEM_TYPE_WEATHER_DATA = 1
const val ITEM_TYPE_WEATHER_ICON = 2

class OpenWeatherAdapter(private val mData: ArrayList<Any> = ArrayList()): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemCallback: ItemCallback? = null

    override fun getItemViewType(position: Int): Int {
        return when(mData[position]) {
            is TimeEntity -> ITEM_TYPE_WEATHER_DATA
            is Int -> ITEM_TYPE_WEATHER_ICON
            else -> ITEM_TYPE_WEATHER_UNDEFINED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ITEM_TYPE_WEATHER_DATA -> WeatherDataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather_data, parent, false))
            ITEM_TYPE_WEATHER_ICON -> WeatherIconViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather_icon, parent, false))
            else                   -> ViewHolder(View(parent.context))
        }
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            when(this) {
                is WeatherDataViewHolder -> {
                    tvStartTime.text = data(position).startTime
                    tvEndTime.text = data(position).endTime
                    tvParameterName.text = data(position).parameter.parameterName
                    tvParameterUnit.text = data(position).parameter.parameterUnit
                }
                is WeatherIconViewHolder -> {
                }
            }
        }

    }

    private fun data(position: Int) = (mData[position] as TimeEntity)

    interface ItemCallback {
        fun onClick(location: TimeEntity)
    }

    inner class WeatherDataViewHolder(itemview: View): RecyclerView.ViewHolder(itemview), View.OnClickListener {
        val weather_item = itemview.findViewById<RelativeLayout>(R.id.weather_item)
        val tvStartTime = itemview.findViewById<TextView>(R.id.tvStartTime)
        val tvEndTime = itemview.findViewById<TextView>(R.id.tvEndTime)
        val tvParameterName = itemview.findViewById<TextView>(R.id.tvParameterName)
        val tvParameterUnit = itemview.findViewById<TextView>(R.id.tvParameterUnit)

        init {
            weather_item.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            when(view?.id) {
                weather_item.id -> { loadWeatherDetail(mData[adapterPosition] as TimeEntity) }
            }
        }

        fun loadWeatherDetail(entity: TimeEntity) {
            itemView.context.loadActivityWithBundle(OpenWeatherDetailActivity::class.java) {
                Bundle().apply {
                    putSerializable(BUNDLE_TIME, entity)
                }
            }
        }
    }

    class WeatherIconViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    fun setItemCallback(callback: ItemCallback?) {
        itemCallback = callback
    }

    fun setDatas(datablock: () -> ArrayList<Any>) {
        mData.clear()
        mData.addAll(datablock())
        notifyDataSetChanged()
    }
}