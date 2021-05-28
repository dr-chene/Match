package com.viper.lib_net.bean

/**
 * created by viper on 2021/5/25
 * desc
 */
data class NetResponse<T>(
    val data: T?,
    val flag: Boolean,
    val message: String?
)
