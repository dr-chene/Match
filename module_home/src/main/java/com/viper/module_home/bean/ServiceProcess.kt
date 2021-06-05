package com.viper.module_home.bean

import androidx.recyclerview.widget.DiffUtil

/**
 * created by viper on 2021/6/5
 * desc
 */
data class ServiceProcess(
    val number: String,
    val title: String
)

object ServiceProcessDiffCallBack : DiffUtil.ItemCallback<ServiceProcess>() {
    override fun areItemsTheSame(oldItem: ServiceProcess, newItem: ServiceProcess): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: ServiceProcess, newItem: ServiceProcess): Boolean {
        return oldItem.title == newItem.title
    }
}