package com.viper.module_home.repository

import com.viper.module_article.article.ArticleRepository
import com.viper.module_article.article.ArticleService

/**
 * created by viper on 2021/5/31
 * desc
 */
class HomeRepository(
    api: ArticleService
) : ArticleRepository<ArticleService>(api) {
    fun getArticlesFromLocal(key: String) = dao.getArticles(key)
    fun getArticlesFromLocal(key: String, cate: String) = dao.getArticles(key, cate)
    fun getArticlesFromLocal(key: String, cate: String, start: String, end: String) = dao.getArticles(key, cate, start, end)
    fun getArticlesFromLocalByCate(cate: String) = dao.getArticlesByCate(cate)
    fun getArticlesFromLocalByDate(start: String, end: String) = dao.getArticlesByTime(start, end)
//    suspend fun clearAll(){
//        dao.clear()
//    }
}