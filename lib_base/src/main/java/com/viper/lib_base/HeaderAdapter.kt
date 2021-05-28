package com.viper.lib_base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * created by viper on 2021/5/27
 * desc
 */
abstract class HeaderAdapter<T, H : ViewDataBinding, VM : BaseViewModel, I : ViewDataBinding>(
    diffCallBack: DiffUtil.ItemCallback<T>
) : ListAdapter<T, RecyclerView.ViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> getHeaderViewHolder(parent)
            else -> getItemViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder<*, *> -> holder.onInit()
            is ItemViewHolder<*> -> onItemBind(holder, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0
        else 1
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }

    abstract fun getItemViewHolder(parent: ViewGroup): ItemViewHolder<I>
    abstract fun getHeaderViewHolder(parent: ViewGroup): HeaderViewHolder<H, VM>
    abstract fun onItemBind(holder: ItemViewHolder<*>, position: Int)
}

abstract class HeaderViewHolder<V : ViewDataBinding, VM : BaseViewModel>(
    protected val binding: V,
    protected val viewModel: VM
) : RecyclerView.ViewHolder(binding.root) {
    abstract fun onInit()
}

abstract class ItemViewHolder<V : ViewDataBinding>(
    protected val binding: V
) : RecyclerView.ViewHolder(binding.root)