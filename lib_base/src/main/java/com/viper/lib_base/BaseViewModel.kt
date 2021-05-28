package com.viper.lib_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * created by viper on 2021/5/26
 * desc
 */
abstract class BaseViewModel : ViewModel() {

    val isRefreshing: LiveData<Boolean>
        get() = refreshing
    protected val refreshing = MutableLiveData<Boolean>()
}