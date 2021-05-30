package com.viper.module_expert.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_article.article.Article
import com.viper.module_article.article.ArticleDiffCallBack
import com.viper.module_article.article.onClick
import com.viper.module_expert.databinding.RecycleItemExpert2ArticleBinding

/**
 * created by viper on 2021/5/29
 * desc
 */
class Expert2ArticleRecyclerViewAdapter: ListAdapter<Article, Expert2ArticleItemViewHolder>(ArticleDiffCallBack) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Expert2ArticleItemViewHolder {
        return Expert2ArticleItemViewHolder(
            RecycleItemExpert2ArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Expert2ArticleItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class Expert2ArticleItemViewHolder(
    private val binding: RecycleItemExpert2ArticleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.article = article
        binding.root.setOnClickListener {
            article.onClick(binding.root.context)
        }
        binding.executePendingBindings()
    }
}