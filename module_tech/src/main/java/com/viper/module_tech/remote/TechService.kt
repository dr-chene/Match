package com.viper.module_tech.remote

import com.viper.lib_net.article.ArticleService
import com.viper.lib_net.bean.Article
import com.viper.lib_net.bean.NetResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * created by viper on 2021/5/28
 * desc
 */
interface TechService : ArticleService {

    @POST("/blog/getTechPlateBlogs")
    override suspend fun getArticles(
        @Body json: RequestBody
    ): NetResponse<List<Article>>
}