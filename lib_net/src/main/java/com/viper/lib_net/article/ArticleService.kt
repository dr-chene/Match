package com.viper.lib_net.article

import com.viper.lib_net.bean.Article
import com.viper.lib_net.bean.NetResponse
import okhttp3.RequestBody

/**
 * created by viper on 2021/5/28
 * desc
 */
interface ArticleService {

    suspend fun getArticles(
        json: RequestBody
    ): NetResponse<List<Article>>
}