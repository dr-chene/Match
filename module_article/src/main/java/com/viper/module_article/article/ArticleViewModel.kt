package com.viper.module_article.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.viper.lib_base.BaseViewModel
import com.viper.lib_net.request
import com.viper.lib_net.result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            repository.getNews(cate, key).data?.let {
                withContext(Dispatchers.Main){
                    _lists.postValue(it)
                }
            }
            refreshing.postValue(false)
        }
    }
}