package com.viper.module_news.remote

import com.viper.module_article.article.Article
import com.viper.lib_net.bean.NetResponse
import com.viper.module_article.article.ArticleService
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * created by viper on 2021/5/27
 * desc
 */
interface NewsService: ArticleService {

    @POST("/blog/getInfoPlateBlogs")
    override suspend fun getArticles(
        @Body json: RequestBody
    ): NetResponse<List<Article>>
}