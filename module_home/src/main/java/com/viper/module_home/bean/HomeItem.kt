package com.viper.module_home.bean

import androidx.recyclerview.widget.DiffUtil

/**
 * created by viper on 2021/5/26
 * desc
 */
data class HomeItem(
    val filed: String,
    val name: String
) {
    object HomeItemDiffCallback : DiffUtil.ItemCallback<HomeItem>() {
        override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem.filed == newItem.filed
        }

        override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem.name == newItem.name
        }

    }
}