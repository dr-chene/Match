package com.viper.module_home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.viper.module_article.article.ArticleService
import com.viper.module_article.article.ArticleViewModel
import com.viper.module_home.repository.HomeCateRepository
import com.viper.module_home.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * created by viper on 2021/5/26
 * desc
 */
class HomeViewModel(
    repository: HomeRepository,
    private val cateRepository: HomeCateRepository
) : ArticleViewModel<ArticleService, HomeRepository>(repository) {

//    fun clearAll() {
//        CoroutineScope(Dispatchers.IO).launch {
//            repository.clearAll()
//        }
//    }

    val cate: LiveData<List<String>>
        get() = _cate
    private val _cate = MutableLiveData<List<String>>()
    fun getCate() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = arrayListOf<String>()
            cateRepository.getCate().data?.let {
                res.addAll(it.news)
                res.addAll(it.policies)
                res.addAll(it.techs)
                res.addAll(it.experts)
            }
            withContext(Dispatchers.Main) {
                _cate.postValue(res)
            }
        }
    }

    fun getArticles(key: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val values = repository.getArticlesFromLocal(key)
            withContext(Dispatchers.Main) {
                postValue(values)
            }
        }
    }

    fun getArticles(key: String, cate: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val values = repository.getArticlesFromLocal(key, cate)
            withContext(Dispatchers.Main) {
                postValue(values)
            }
        }
    }

    fun getArticles(key: String, cate: String, start: String, end: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val values = repository.getArticlesFromLocal(key, cate, start, end)
            withContext(Dispatchers.Main) {
                postValue(values)
            }
        }
    }

    fun getArticlesByDate(start: String, end: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val values = repository.getArticlesFromLocalByDate(start, end)
            withContext(Dispatchers.Main) {
                postValue(values)
            }
        }
    }

    fun getArticlesByCate(cate: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val values = repository.getArticlesFromLocalByCate(cate)
            withContext(Dispatchers.Main) {
                postValue(values)
            }
        }
    }
}