package com.viper.module_article.article

import com.viper.lib_net.bean.NetResponse
import com.viper.lib_net.toJson
import org.json.JSONObject

/**
 * created by viper on 2021/5/28
 * desc
 */
open class ArticleRepository<T: ArticleService>(
    private val api: T
) {
    suspend fun getNews(category: String, title: String? = null): NetResponse<List<Article>> {
        JSONObject().apply {
            put("category", category)
            if (title != null) put("title", title)
            return api.getArticles(toJson())
        }
    }
}