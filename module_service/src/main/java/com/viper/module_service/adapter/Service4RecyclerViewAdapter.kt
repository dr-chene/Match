package com.viper.module_service.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.lib_net.showToast
import com.viper.module_service.bean.Order
import com.viper.module_service.bean.ServiceItem
import com.viper.module_service.bean.ServiceItemDiffCallBack
import com.viper.module_service.databinding.RecycleItemOrderBinding
import com.viper.module_service.databinding.RecycleItemServiceBinding

/**
 * created by viper on 2021/6/5
 * desc
 */
class Service4RecyclerViewAdapter :
    ListAdapter<ServiceItem, ServiceViewHolder>(ServiceItemDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(
            RecycleItemServiceBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ServiceViewHolder(
    private val binding: RecycleItemServiceBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(service: ServiceItem) {
        binding.service = service
        binding.root.setOnClickListener {
            "功能暂未实现".showToast()
        }
        binding.executePendingBindings()
    }
}