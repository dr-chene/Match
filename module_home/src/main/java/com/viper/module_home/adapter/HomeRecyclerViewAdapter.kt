package com.viper.module_home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.viper.lib_net.showToast
import com.viper.module_home.bean.Banner
import com.viper.module_home.bean.HomeItem
import com.viper.module_home.databinding.RecycleItemHomeHeaderBinding
import com.viper.module_home.databinding.RecycleItemHomeBinding
import com.viper.module_home.viewmodel.HomeViewModel
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

/**
 * created by viper on 2021/5/26
 * desc
 */
class HomeRecyclerViewAdapter(private val viewModel: HomeViewModel) :
    ListAdapter<HomeItem, RecyclerView.ViewHolder>(HomeItem.HomeItemDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> HomeHeaderViewHolder(
                RecycleItemHomeHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), viewModel
            )
            else -> HomeItemViewHolder(
                RecycleItemHomeBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) (holder as HomeHeaderViewHolder).onInit()
        else (holder as HomeItemViewHolder).bind(getItem(position - 1))
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0
        else 1
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }

    class HomeItemViewHolder(
        private val binding: RecycleItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(homeItem: HomeItem) {
            binding.item = homeItem
            binding.executePendingBindings()
        }
    }

    class HomeHeaderViewHolder(
        private val binding: RecycleItemHomeHeaderBinding,
        private val viewModel: HomeViewModel
    ) : RecyclerView.ViewHolder(binding.root) {

        private val banners by lazy {
            arrayListOf(Banner("", ""))
        }

        init {
            binding.homeBanner.setAdapter(object : BannerImageAdapter<Banner>(banners) {
                override fun onBindView(
                    holder: BannerImageHolder,
                    data: Banner,
                    position: Int,
                    size: Int
                ) {
                    Glide.with(holder.itemView)
                        .load(data.img)
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                        .into(holder.imageView)
                }
            }).addBannerLifecycleObserver(binding.lifecycleOwner).indicator = CircleIndicator(binding.root.context)
            binding.homeSearchButton.setOnClickListener {
                val key = binding.homeSearchBar.text.toString()
                if (key.isNotBlank()) search(key)
                else "请输入关键词".showToast()
            }
        }

        fun onInit() {

        }

        private fun search(key: String){
//            viewModel.search(key)
        }
    }
}