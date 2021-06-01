package com.viper.module_home.repository

import com.viper.lib_net.bean.NetResponse
import com.viper.lib_net.toJson
import com.viper.module_article.article.Article
import com.viper.module_home.bean.Cate
import com.viper.module_home.remote.CateService

/**
 * created by viper on 2021/5/31
 * desc
 */
class HomeCateRepository(
    private val api: CateService
) {
    suspend fun getCate(): NetResponse<Cate> = api.getCate()
}