package com.viper.lib_net.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * created by viper on 2021/6/1
 * desc
 */
@BindingAdapter("bindText")
fun bindText(view: TextView, content: String?){
    if (content.isNullOrBlank()) {
        view.text = "暂无数据"
    } else view.text = content
}