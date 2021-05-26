package com.viper.module_service.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_service.bean.Order
import com.viper.module_service.databinding.RecycleItemOrderBinding

/**
 * created by viper on 2021/5/26
 * desc
 */
class ServiceRecyclerViewAdapter :
    ListAdapter<Order, RecyclerView.ViewHolder>(Order.OrderDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return OrderViewHolder(
            RecycleItemOrderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OrderViewHolder).bind(getItem(position))
    }

    class OrderViewHolder(
        private val binding: RecycleItemOrderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.order = order
            binding.executePendingBindings()
        }
    }
}