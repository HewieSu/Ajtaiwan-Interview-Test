package com.hewie.ajtaiwaninterviewtest

import android.content.Context
import com.hewie.ajtaiwaninterviewtest.defined.SP_LOGIN
import com.hewie.ajtaiwaninterviewtest.util.getPrefString
import com.hewie.ajtaiwaninterviewtest.util.putPrefString

class MainPresenter(private val views: Views) {

    fun checkLogin(context: Context?) {
        context?.let {
            if(it.getPrefString(SP_LOGIN).isNotEmpty()) {
                views.showLoginMessage()
            } else {
                login(context)
            }
        }
    }

    private fun login(context: Context?) {
        context?.let {
            it.putPrefString(SP_LOGIN, "Hewie")
        }
    }
    interface Views {
        fun showLoginMessage()
    }
}