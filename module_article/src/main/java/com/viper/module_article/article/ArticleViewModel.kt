package com.viper.module_article.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.viper.lib_base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * created by viper on 2021/5/28
 * desc
 */
open class ArticleViewModel<T: ArticleService, E: ArticleRepository<T>>(
    protected val repository: E
) : BaseViewModel(){

    val lists: LiveData<List<Article>>
        get() = _lists
    private val _lists = MutableLiveData<List<Article>>()

    fun refresh(cate: String, key: String? = null){
        refreshing.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            repository.getArticlesFromNet(cate, key).data?.let {
                withContext(Dispatchers.Main){
                    _lists.postValue(it)
                }
//                repository.insertArticle(it)
            }
            refreshing.postValue(false)
        }
    }

    protected fun postValue(values: List<Article>){
        _lists.postValue(values)
    }
}