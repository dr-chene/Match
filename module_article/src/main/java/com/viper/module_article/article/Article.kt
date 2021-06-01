package com.viper.module_article.article

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.viper.module_article.ArticleActivity
import java.io.Serializable
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*

/**
 * created by viper on 2021/5/28
 * desc
 */
@Entity
data class Article(
    @PrimaryKey
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

fun String.toTimeLong(): Long =
    SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(this, ParsePosition(0))?.time ?: 0