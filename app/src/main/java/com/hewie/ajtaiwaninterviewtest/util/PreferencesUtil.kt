package com.hewie.ajtaiwaninterviewtest.util

import android.content.Context
import android.preference.PreferenceManager

fun Context.putPrefString(key: String, value: String) {
    val profilePreferences = PreferenceManager.getDefaultSharedPreferences(this)
    val profileEditor = profilePreferences.edit()
    profileEditor.putString(key, value)
    profileEditor.apply()
}

fun Context.getPrefString(key: String): String {
    val profilePreferences = PreferenceManager.getDefaultSharedPreferences(this)
    return profilePreferences.getString(key, "")!!
}