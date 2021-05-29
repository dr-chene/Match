package com.viper.module_news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.lib_net.bean.Article
import com.viper.module_news.bean.News
import com.viper.module_news.databinding.RecycleItemNewsBinding

/**
 * created by viper on 2021/5/28
 * desc
 */
class NewsRecyclerViewAdapter: ListAdapter<Article, NewsItemViewHolder>(Article.ArticleDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder(
            RecycleItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NewsItemViewHolder(
    private val binding: RecycleItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article){
        binding.article = article
        binding.executePendingBindings()
    }
}