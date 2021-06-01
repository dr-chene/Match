package com.viper.match

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.viper.module_article.article.Article
import com.viper.module_article.article.ArticleDao

/**
 * created by viper on 2021/5/23
 * desc
 */
@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        private const val DATA_BASE_NAME = "match.db"

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDataBase::class.java, DATA_BASE_NAME).build()
    }
}