package com.viper.module_service.bean

import androidx.recyclerview.widget.DiffUtil

/**
 * created by viper on 2021/5/26
 * desc
 */
data class Order(
    val name: String,
    val id: Long,
    val state: Int,
    val comment: String,
    val price: Int
) {
    object OrderDiffCallBack : DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem == newItem
        }
    }
}