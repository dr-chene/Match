package com.viper.lib_net

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import org.koin.java.KoinJavaComponent

/**
 * created by viper on 2021/5/25
 * desc
 */
private var toast: Toast? = null

fun String?.showToast() {
    this?.let {
        CoroutineScope(Dispatchers.Main).launch {
            toast?.cancel()
            toast = Toast.makeText(KoinJavaComponent.get(Context::class.java), it, Toast.LENGTH_SHORT)
            toast?.show()
        }
    }
}

private fun RecyclerView.isSlideToBottom() =
    (this.computeVerticalScrollExtent() + this.computeVerticalScrollOffset()
            >= this.computeVerticalScrollRange())

fun RecyclerView.onLoadMore(load: () -> Unit) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            if (newState == RecyclerView.SCROLL_STATE_DRAGGING && recyclerView.isSlideToBottom()) {
                load()
            }
        }
    })
}

fun JSONObject.toJson() =
    RequestBody.create(MediaType.parse("application/json; charset=utf-8"), this.toString())