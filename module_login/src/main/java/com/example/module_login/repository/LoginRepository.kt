package com.example.module_login.repository

import com.example.module_login.remote.LoginService
import com.viper.lib_net.bean.NetResponse
import com.viper.lib_net.toJson
import org.json.JSONObject

class LoginRepository(private val api: LoginService) {

    suspend fun login(username: String, password: String): NetResponse<String> {
        JSONObject().apply {
            put("username", username)
            put("password", password)
            return api.login(toJson())
        }
    }

    suspend fun register(
        username: String,
        password: String,
        telephone: String? = null
    ): NetResponse<Nothing> {
        JSONObject().apply {
            put("username", username)
            put("password", password)
            put("telephone", telephone)
            return api.register(toJson())
        }
    }

    suspend fun check(username: String): NetResponse<Nothing> {
        JSONObject().apply {
            put("username", username)
            return api.check(toJson())
        }
    }
}