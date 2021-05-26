package com.viper.lib_base

import android.content.Context
import android.widget.Toast
import org.koin.java.KoinJavaComponent

/**
 * created by viper on 2021/5/25
 * desc
 */
private var toast: Toast? = null

fun String?.showToast(){
    toast?.cancel()
    toast = Toast.makeText(KoinJavaComponent.get(Context::class.java), this, Toast.LENGTH_SHORT)
    toast?.show()
}