package com.viper.module_news.remote

import com.viper.lib_net.bean.Article
import com.viper.lib_net.bean.NetResponse
import com.viper.module_news.bean.News
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * created by viper on 2021/5/27
 * desc
 */
interface NewsService {

    @POST("/blog/getInfoPlateBlogs")
    suspend fun getNews(
        @Body json: RequestBody
    ): NetResponse<List<Article>>
}