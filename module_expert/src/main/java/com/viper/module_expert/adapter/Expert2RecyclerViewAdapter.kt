package com.viper.module_expert.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.databinding.RecycleItemExpert2Binding

/**
 * created by viper on 2021/5/29
 * desc
 */
class Expert2RecyclerViewAdapter(
    private val blog: (Expert2) -> Unit
) : ListAdapter<Expert2, Expert2ViewHolder>(Expert2.Expert2DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Expert2ViewHolder {
        return Expert2ViewHolder(
            RecycleItemExpert2Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), blog
        )
    }

    override fun onBindViewHolder(holder: Expert2ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class Expert2ViewHolder(
    private val binding: RecycleItemExpert2Binding,
    private val blog: (Expert2) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(expert: Expert2) {
        binding.expert = expert
        binding.expert2ExpertBlogs.setOnClickListener {
            blog(expert)
        }
        binding.executePendingBindings()
    }
}