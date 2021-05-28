package com.viper.module_news.repository

import com.viper.lib_net.bean.NetResponse
import com.viper.lib_net.toJson
import com.viper.module_news.bean.News
import com.viper.module_news.remote.NewsService
import org.json.JSONObject

/**
 * created by viper on 2021/5/27
 * desc
 */
class NewsRepository(
    private val api: NewsService
) {

    suspend fun getNews(category: String, title: String? = null): NetResponse<List<News>> {
        JSONObject().apply {
            put("category", category)
            if (title != null) put("title", title)
            return api.getNews(toJson())
        }
    }
}