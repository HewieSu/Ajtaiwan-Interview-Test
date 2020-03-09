package com.hewie.ajtaiwaninterviewtest.common

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    var loading = ObservableBoolean(false)

    fun startLoading() {
        loading.set(true)
    }

    fun stopLoading() {
        loading.set(false)
    }
}