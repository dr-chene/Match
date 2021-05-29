package com.viper.module_expert.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.viper.lib_base.BaseViewModel
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.repository.Expert2Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * created by viper on 2021/5/26
 * desc
 */
class Expert2ViewModel(
    private val repository: Expert2Repository
) : BaseViewModel() {

    val experts: LiveData<List<Expert2>>
        get() = _experts
    private val _experts = MutableLiveData<List<Expert2>>()

    fun refresh() {
        refreshing.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            val list = arrayListOf<Expert2>()
            repository.getExperts().data?.forEach {
                repository.getExpert(it.name).data?.let { expert -> list.add(expert) }
            }
            _experts.postValue(list)
            refreshing.postValue(false)
        }
    }
}