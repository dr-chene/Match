package com.viper.module_home.remote

import com.viper.lib_net.bean.NetResponse
import com.viper.module_home.bean.Cate
import okhttp3.RequestBody
import retrofit2.http.POST

/**
 * created by viper on 2021/5/31
 * desc
 */
interface CateService {

    @POST("/blog/getCategorys")
    suspend fun getCate(): NetResponse<Cate>
}