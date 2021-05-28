package com.viper.module_news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.viper.lib_base.HeaderAdapter
import com.viper.lib_base.HeaderViewHolder
import com.viper.lib_base.ItemViewHolder
import com.viper.module_news.bean.News
import com.viper.module_news.databinding.RecycleItemNewsBinding
import com.viper.module_news.databinding.RecycleItemNewsHeaderBinding
import com.viper.module_news.viewmodel.NewsViewModel

/**
 * created by viper on 2021/5/27
 * desc
 */
//class NewsListRecyclerViewAdapter(private val viewModel: NewsViewModel) :
//    HeaderAdapter<News, RecycleItemNewsHeaderBinding, NewsViewModel, RecycleItemNewsBinding>(News.NewsDiffCallback) {
//
//    override fun getItemViewHolder(parent: ViewGroup) = NewsItemViewHolder(
//        RecycleItemNewsBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false
//        )
//    )
//
//    override fun getHeaderViewHolder(parent: ViewGroup) = NewsHeaderViewHolder(
//        RecycleItemNewsHeaderBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false
//        ), viewModel
//    )
//
//    override fun onItemBind(holder: ItemViewHolder<*>, position: Int) {
//        (holder as NewsItemViewHolder).bind(getItem(position - 1))
//    }
//}
//
//class NewsItemViewHolder(
//    binding: RecycleItemNewsBinding
//) : ItemViewHolder<RecycleItemNewsBinding>(binding) {
//
//    fun bind(news: News) {
//        binding.news = news
//        binding.executePendingBindings()
//    }
//}
//
//class NewsHeaderViewHolder(
//    binding: RecycleItemNewsHeaderBinding,
//    viewModel: NewsViewModel
//) : HeaderViewHolder<RecycleItemNewsHeaderBinding, NewsViewModel>(binding, viewModel) {
//
//    init {
//
//    }
//
//    override fun onInit() {
//
//    }
//}