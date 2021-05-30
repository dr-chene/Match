package com.viper.module_article.article

import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.viper.module_article.ArticleActivity
import java.io.Serializable

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
) : Serializable

object ArticleDiffCallBack : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.content == newItem.content
    }
}

fun Article.onClick(context: Context){
    Intent(context, ArticleActivity::class.java).apply {
        putExtra("article", this@onClick)
        context.startActivity(this)
    }
}