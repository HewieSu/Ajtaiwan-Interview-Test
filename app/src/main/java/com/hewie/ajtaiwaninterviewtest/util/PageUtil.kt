package com.hewie.ajtaiwaninterviewtest.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun <T> Context?.loadActivityWithBundle(targetActivity: Class<T>, f: () -> Bundle? = { null }) {
    this?.let {
        val intent = Intent(this, targetActivity)
        val bundle = f()
        if(bundle != null) intent.putExtras(bundle)
        startActivity(intent)
    }
}

fun FragmentActivity.loadFragment(container: Int, fragment: Fragment): Fragment {
    supportFragmentManager.beginTransaction().let {
        it.replace(container, fragment, fragment::class.java.simpleName)
        it.commit()
    }

    return fragment
}