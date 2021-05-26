package com.viper.lib_net.bean

/**
 * created by viper on 2021/5/25
 * desc
 */
sealed class NetResult<out T> {
    data class Success<out T>(val value: T) : NetResult<T>()

    data class Failure(val errorMsg: String?) : NetResult<Nothing>()
}

inline fun <reified T> NetResult<T>.doSuccess(onSuccess: (T) -> Unit){
    if (this is NetResult.Success) {
        onSuccess(value)
    }
}

inline fun <reified T> NetResult<T>.doFailure(onFailure: (String?) -> Unit) {
    if (this is NetResult.Failure) {
        onFailure(errorMsg)
    }
}