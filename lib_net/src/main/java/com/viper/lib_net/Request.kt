package com.viper.lib_net

import com.viper.lib_net.bean.NetResponse
import com.viper.lib_net.bean.NetResult
import com.viper.lib_net.bean.doFailure
import com.viper.lib_net.bean.doSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.withContext

/**
 * created by viper on 2021/5/25
 * desc
 */
fun <T> NetResponse<T>.request(requestSuccess: ((T) -> Unit)? = null) = flow {
    try {
        if (this@request.flag) {
            this@request.data?.let { requestSuccess?.invoke(it) }
            emit(NetResult.Success(this@request.data))
        } else {
            emit(NetResult.Failure(this@request.message))
        }
    } catch (e: Exception) {
        emit(NetResult.Failure(e.message))
    }
}

suspend inline fun <reified T> Flow<NetResult<T>>.result(
    noinline onCompletion: (() -> Unit)? = null,
    crossinline onSuccess: (T) -> Unit
) {
    this.onCompletion { onCompletion?.invoke() }
        .collectLatest {
            withContext(Dispatchers.Main) {
                it.doSuccess { data ->
                    onSuccess(data)
                }
                it.doFailure { errorMsg ->
                    errorMsg?.showToast()
                }
            }
        }
}