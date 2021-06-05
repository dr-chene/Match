package com.viper.module_service.bean

import androidx.recyclerview.widget.DiffUtil

/**
 * created by viper on 2021/6/5
 * desc
 */
data class ServiceItem(
    val title: String,
    val img: Int? = null
)

object ServiceItemDiffCallBack : DiffUtil.ItemCallback<ServiceItem>() {
    override fun areItemsTheSame(oldItem: ServiceItem, newItem: ServiceItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ServiceItem, newItem: ServiceItem): Boolean {
        return oldItem.img == newItem.img
    }
}
