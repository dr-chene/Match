package com.viper.module_policy.remote

import com.viper.module_article.article.ArticleService
import com.viper.module_article.article.Article
import com.viper.lib_net.bean.NetResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * created by viper on 2021/5/28
 * desc
 */
interface PolicyService: com.viper.module_article.article.ArticleService {

    @POST("/blog/getPolicyPlateBlogs")
    override suspend fun getArticles(
        @Body json: RequestBody
    ): NetResponse<List<com.viper.module_article.article.Article>>
}