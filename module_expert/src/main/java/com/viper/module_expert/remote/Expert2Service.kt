package com.viper.module_expert.remote

import com.viper.lib_net.bean.NetResponse
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.bean.SimpleExpert2
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * created by viper on 2021/5/29
 * desc
 */
interface Expert2Service {

    @POST("/blog/getExperts")
    suspend fun getExperts(): NetResponse<List<SimpleExpert2>>

    @POST("/blog/getExpertInfo")
    suspend fun getExpert(
        @Body json: RequestBody
    ): NetResponse<Expert2>
}