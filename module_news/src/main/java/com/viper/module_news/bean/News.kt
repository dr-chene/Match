package com.viper.module_news.bean

import androidx.recyclerview.widget.DiffUtil

/**
 * created by viper on 2021/5/27
 * desc
 */
data class News(
    val id: Long,
    val category: String,
    val categoryId: Int,
    val title: String,
    val date: String,
    val author: String,
    val content: String
) {
    object NewsDiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.content == newItem.content
        }
    }
}
