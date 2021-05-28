package com.viper.lib_net.bean

import androidx.recyclerview.widget.DiffUtil

/**
 * created by viper on 2021/5/28
 * desc
 */
data class Article(
    val id: Long,
    val category: String,
    val categoryId: Int,
    val title: String,
    val date: String,
    val author: String,
    val content: String
) {
    object ArticleDiffCallBack : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.content == newItem.content
        }
    }
}