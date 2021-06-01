package com.viper.module_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_article.article.Article
import com.viper.module_article.article.ArticleDiffCallBack
import com.viper.module_article.article.onClick
import com.viper.module_home.databinding.RecycleItemHomeBinding

/**
 * created by viper on 2021/5/26
 * desc
 */
class HomeRecyclerViewAdapter : ListAdapter<Article, HomeItemViewHolder>(ArticleDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        return HomeItemViewHolder(
            RecycleItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeItemViewHolder(
    private val binding: RecycleItemHomeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.article = article
        binding.root.setOnClickListener {
            article.onClick(binding.root.context)
        }
        binding.executePendingBindings()
    }
}