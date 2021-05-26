package com.viper.module_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_home.bean.HomeItem
import com.viper.module_home.databinding.RecycleItemHomeBinding

/**
 * created by viper on 2021/5/26
 * desc
 */
class HomeRecyclerViewAdapter :
    ListAdapter<HomeItem, RecyclerView.ViewHolder>(HomeItem.HomeItemDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeItemViewHolder(
            RecycleItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeItemViewHolder).bind(getItem(position))
    }

    class HomeItemViewHolder(
        private val binding: RecycleItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(homeItem: HomeItem) {
            binding.item = homeItem
            binding.executePendingBindings()
        }
    }
}