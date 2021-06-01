package com.viper.module_news.repository

import com.viper.module_article.article.Article
import com.viper.lib_net.bean.NetResponse
import com.viper.lib_net.toJson
import com.viper.module_article.article.ArticleRepository
import com.viper.module_news.remote.NewsService
import org.json.JSONObject

/**
 * created by viper on 2021/5/27
 * desc
 */
class NewsRepository(
    api: NewsService
): ArticleRepository<NewsService>(api)