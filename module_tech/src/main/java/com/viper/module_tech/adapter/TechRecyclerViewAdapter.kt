package com.viper.module_tech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.lib_net.bean.Article
import com.viper.module_tech.databinding.RecycleItemTech2Binding

/**
 * created by viper on 2021/5/28
 * desc
 */
class TechRecyclerViewAdapter :
    ListAdapter<Article, TechItemViewHolder>(Article.ArticleDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechItemViewHolder {
        return TechItemViewHolder(
            RecycleItemTech2Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TechItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class TechItemViewHolder(
    private val binding: RecycleItemTech2Binding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tech: Article) {
        binding.tech = tech
        binding.executePendingBindings()
    }
}