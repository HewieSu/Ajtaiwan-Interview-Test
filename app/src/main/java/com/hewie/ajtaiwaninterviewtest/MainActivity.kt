package com.hewie.ajtaiwaninterviewtest

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.hewie.ajtaiwaninterviewtest.ui.openweather.OpenWeatherFragment
import com.hewie.ajtaiwaninterviewtest.util.loadFragment

class MainActivity : FragmentActivity(), MainPresenter.Views {

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.checkLogin(this)

        loadFragment(R.id.flContainer, OpenWeatherFragment())
    }

    override fun showLoginMessage() {
        Toast.makeText(this, R.string.login_message, Toast.LENGTH_SHORT).show()
    }
}
