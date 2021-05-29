package com.viper.module_expert.bean

import androidx.recyclerview.widget.DiffUtil
import com.viper.lib_net.bean.Article

/**
 * created by viper on 2021/5/29
 * desc
 */
data class Expert2(
    val name: String,
    val identification: String,
    val image: String?,
    val resume: String?,
    val blogs: List<Article>
){
    object Expert2DiffCallBack: DiffUtil.ItemCallback<Expert2>() {
        override fun areItemsTheSame(oldItem: Expert2, newItem: Expert2): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Expert2, newItem: Expert2): Boolean {
            return oldItem.resume == newItem.resume
        }
    }
}