package com.viper.module_home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.viper.lib_base.BaseViewModel
import com.viper.module_home.bean.HomeItem
import kotlinx.coroutines.*

/**
 * created by viper on 2021/5/26
 * desc
 */
class HomeViewModel : BaseViewModel() {
    val lists: LiveData<List<HomeItem>>
        get() = _lists
    private val _lists = MutableLiveData<List<HomeItem>>()

//    val isRefreshing: LiveData<Boolean>
//        get() = _isRefreshing
//    private val _isRefreshing = MutableLiveData<Boolean>()

//    fun refresh() {
//        CoroutineScope(Dispatchers.IO).launch {
//            delay(2000)
//            withContext(Dispatchers.Main) {
//                val list = arrayListOf<HomeItem>()
//                for (i in 0..10) {
//                    list.add(HomeItem("java", ('a' + i).toString()))
//                }
//                _lists.postValue(list)
//                _isRefreshing.postValue(false)
//            }
//        }
//    }

//    fun search(key: String) {
//        _isRefreshing.postValue(true)
//        refresh()
//    }
}