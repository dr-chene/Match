package com.example.module_login.remote

import com.viper.lib_net.bean.NetResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
Created by chene on @date 20-12-10 下午10:18
 **/
interface LoginService {

    @POST("/user/login")
    suspend fun login(
        @Body json: RequestBody
    ): NetResponse<String>

    @POST("/user/register")
    suspend fun register(
        @Body json: RequestBody
    ): NetResponse<Nothing>

    @POST("/user/checkUsername")
    suspend fun check(
        @Body json: RequestBody
    ): NetResponse<Nothing>
}