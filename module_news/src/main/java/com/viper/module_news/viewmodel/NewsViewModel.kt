package com.viper.module_news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.viper.lib_base.BaseViewModel
import com.viper.module_article.article.Article
import com.viper.lib_net.request
import com.viper.lib_net.result
import com.viper.module_news.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * created by viper on 2021/5/26
 * desc
 */
class NewsViewModel(
    private val repository: NewsRepository
) : BaseViewModel() {

    val lists: LiveData<List<com.viper.module_article.article.Article>>
        get() = _lists
    private val _lists = MutableLiveData<List<com.viper.module_article.article.Article>>()

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