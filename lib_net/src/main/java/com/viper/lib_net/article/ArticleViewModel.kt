package com.viper.lib_net.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.viper.lib_base.BaseViewModel
import com.viper.lib_net.bean.Article
import com.viper.lib_net.request
import com.viper.lib_net.result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * created by viper on 2021/5/28
 * desc
 */
open class ArticleViewModel<T: ArticleService>(
    private val repository: ArticleRepository<T>
) : BaseViewModel(){

    val lists: LiveData<List<Article>>
        get() = _lists
    private val _lists = MutableLiveData<List<Article>>()

    fun refresh(cate: String, key: String? = null){
        refreshing.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            repository.getNews(cate, key).request().result({
                refreshing.postValue(false)
            }) {
                _lists.postValue(it)
            }
        }
    }
}