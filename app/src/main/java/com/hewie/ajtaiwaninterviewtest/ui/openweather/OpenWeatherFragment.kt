package com.hewie.ajtaiwaninterviewtest.ui.openweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.hewie.ajtaiwaninterviewtest.R
import com.hewie.ajtaiwaninterviewtest.common.BaseFragment
import com.hewie.ajtaiwaninterviewtest.params.WeatherForecastParams
import kotlinx.android.synthetic.main.fragment_open_weather.*

class OpenWeatherFragment : BaseFragment(), OpenWeatherPresenter.Views {

    private val binding: ViewDataBinding by lazy { DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context), R.layout.fragment_open_weather, null, false) }
    private val presenter = OpenWeatherPresenter(this)

    private val mAdapter = OpenWeatherAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.setViewBinding(binding)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        initSwipeRefreshLayout()
    }

    private fun initRecyclerView() {
        rvList.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }.let {
            testLoadAPI()
        }
    }

    private fun initSwipeRefreshLayout() {
        swipe_layout.setOnRefreshListener {
            testLoadAPI()
        }
    }

    private fun testLoadAPI() {
        val params = WeatherForecastParams().apply {
            locationName = arrayListOf("臺北市")
            elementName = arrayListOf("MinT")
        }
        presenter.loadWeatherForecast(params)
    }

    override fun loadDatas(data: ArrayList<Any>) {
        mAdapter.setDatas { data }
    }
}