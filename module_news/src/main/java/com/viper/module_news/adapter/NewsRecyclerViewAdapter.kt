package com.viper.module_news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_article.article.Article
import com.viper.module_article.article.ArticleDiffCallBack
import com.viper.module_article.article.onClick
import com.viper.module_news.databinding.RecycleItemNewsBinding

/**
 * created by viper on 2021/5/28
 * desc
 */
class NewsRecyclerViewAdapter : ListAdapter<Article, NewsItemViewHolder>(ArticleDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder(
            RecycleItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
        )
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NewsItemViewHolder(
    private val binding: RecycleItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.article = article
        binding.root.setOnClickListener {
            article.onClick(binding.root.context)
        }
        binding.executePendingBindings()
    }
}