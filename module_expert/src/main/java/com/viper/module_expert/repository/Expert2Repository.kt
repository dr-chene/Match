package com.viper.module_expert.repository

import com.viper.lib_net.bean.NetResponse
import com.viper.lib_net.toJson
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.remote.Expert2Service
import org.json.JSONObject

/**
 * created by viper on 2021/5/29
 * desc
 */
class Expert2Repository(
    private val api: Expert2Service
) {
    suspend fun getExperts() = api.getExperts()

    suspend fun getExpert(name: String): NetResponse<Expert2> {
        JSONObject().apply {
            put("name", name)
            return api.getExpert(toJson())
        }
    }
}