package com.viper.module_article.article

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * created by viper on 2021/5/31
 * desc
 */
@Dao
interface ArticleDao {

    @Query("SELECT * FROM article WHERE title LIKE '%'||:arg0||'%'")
    fun getArticles(key: String): List<Article>

    @Query("SELECT * FROM article WHERE category = :arg1 AND title LIKE '%'||:arg0||'%'")
    fun getArticles(key: String, cate: String): List<Article>

    @Query("SELECT * FROM article WHERE category = :arg1 AND date >= :arg2 AND date <= :arg3 AND title LIKE '%'||:arg0||'%' ORDER BY date DESC")
    fun getArticles(key: String, cate: String, start: String, end: String): List<Article>

    @Query("SELECT * FROM article WHERE category = :arg0")
    fun getArticlesByCate(cate: String): List<Article>

    @Query("SELECT * FROM article WHERE date >= :arg0 AND date <= :arg1")
    fun getArticlesByTime(start: String, end: String): List<Article>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertArticle(vararg articles: Article): Long

//    @Query("DELETE FROM articles")
//    suspend fun clear()
}