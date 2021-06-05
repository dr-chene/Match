package com.viper.module_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_home.bean.ServiceProcess
import com.viper.module_home.bean.ServiceProcessDiffCallBack
import com.viper.module_home.databinding.RecycleItemHome4Binding

/**
 * created by viper on 2021/6/5
 * desc
 */
class Home4RecyclerViewAdapter :
    ListAdapter<ServiceProcess, Home4ViewHolder>(ServiceProcessDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Home4ViewHolder {
        return Home4ViewHolder(
            RecycleItemHome4Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Home4ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class Home4ViewHolder(
    private val binding: RecycleItemHome4Binding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(serviceProcess: ServiceProcess) {
        binding.serviceProcess = serviceProcess
        binding.executePendingBindings()
    }
}