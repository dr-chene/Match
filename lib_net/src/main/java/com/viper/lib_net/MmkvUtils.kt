package com.viper.lib_net

import com.tencent.mmkv.MMKV

/**
 * created by viper on 2021/5/27
 * desc
 */
object MmkvUtils {

    private const val TOKEN = "token"
    private val kv = MMKV.defaultMMKV()

    fun saveToken(token: String) {
        kv?.encode(TOKEN, token)
    }

    fun getToken() = kv?.decodeString(TOKEN)

    fun clear() {
        kv?.clearAll()
        token = null
    }
}