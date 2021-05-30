package com.viper.module_policy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_article.article.Article
import com.viper.module_article.article.ArticleDiffCallBack
import com.viper.module_article.article.onClick
import com.viper.module_policy.databinding.RecycleItemPolicy2Binding

/**
 * created by viper on 2021/5/28
 * desc
 */
class PolicyRecyclerViewAdapter: ListAdapter<Article, PolicyItemViewHolder>(ArticleDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PolicyItemViewHolder {
        return PolicyItemViewHolder(
            RecycleItemPolicy2Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PolicyItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class PolicyItemViewHolder(
    private val binding: RecycleItemPolicy2Binding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(policy: Article) {
        binding.policy = policy
        binding.root.setOnClickListener {
            policy.onClick(binding.root.context)
        }
        binding.executePendingBindings()
    }
}