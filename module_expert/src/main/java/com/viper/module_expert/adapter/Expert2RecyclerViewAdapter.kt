package com.viper.module_expert.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.bean.Expert2DiffCallBack
import com.viper.module_expert.bean.onClick
import com.viper.module_expert.databinding.RecycleItemExpert2Binding
import com.viper.module_expert.databinding.RecycleItemExpert3Binding

/**
 * created by viper on 2021/5/29
 * desc
 */
class Expert2RecyclerViewAdapter : ListAdapter<Expert2, Expert3ViewHolder>(Expert2DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Expert3ViewHolder {
        return Expert3ViewHolder(
            RecycleItemExpert3Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Expert3ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class Expert2ViewHolder(
    private val binding: RecycleItemExpert2Binding,
    private val blog: (Expert2) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(expert: Expert2) {
        binding.expert = expert
        binding.root.setOnClickListener {
            blog(expert)
        }
        binding.executePendingBindings()
    }
}

class Expert3ViewHolder(
    private val binding: RecycleItemExpert3Binding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(expert: Expert2) {
        binding.expert = expert
        binding.root.setOnClickListener {
            expert.onClick(binding.root.context)
        }
        binding.executePendingBindings()
    }
}