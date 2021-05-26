package com.viper.module_home

import android.content.Intent
import android.view.Gravity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.viper.lib_base.showToast
import com.viper.lib_base.view.BaseFragment
import com.viper.module_footprint.FootprintActivity
import com.viper.module_home.adapter.HomeRecyclerViewAdapter
import com.viper.module_home.bean.Banner
import com.viper.module_home.databinding.FragmentHomeBinding
import com.viper.module_home.viewmodel.HomeViewModel
import com.viper.module_info.InfoActivity
import com.viper.module_service.ServiceActivity
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by inject<HomeRecyclerViewAdapter>()
    private val banners by lazy {
        arrayListOf(Banner("", ""))
    }

    override fun onInitView() {
        binding.homeContent.homeMain.apply {
            homeRv.adapter = adapter
            homeBanner.setAdapter(object : BannerImageAdapter<Banner>(banners) {
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
            }).addBannerLifecycleObserver(this@HomeFragment)
                .setIndicator(CircleIndicator(this@HomeFragment.context))
        }
    }

    override fun onInitAction() {
        binding.homeContent.homeAvatar.setOnClickListener {
            binding.homeDrawer.openDrawer(Gravity.LEFT)
        }
        binding.homeNavDrawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_my_info -> {
                    startActivity(Intent(this.context, InfoActivity::class.java))
                    true
                }
                R.id.home_my_footprint -> {
                    startActivity(Intent(this.context, FootprintActivity::class.java))
                    true
                }
                R.id.home_my_wallet -> {
                    "暂不支持该服务".showToast()
                    true
                }
                R.id.home_my_service -> {
                    startActivity(Intent(this.context, ServiceActivity::class.java))
                    true
                }
                R.id.home_my_commitment -> {
                    "暂不支持该服务".showToast()
                    true
                }
                R.id.home_my_tools -> {
                    "暂不支持该服务".showToast()
                    true
                }
                else -> false
            }
        }
        binding.homeContent.homeMain.apply {
            homeSearchButton.setOnClickListener {
                val key = homeSearchBar.text.toString()
                if (key.isNotBlank()) search(key)
                else "请输入关键词".showToast()
            }
        }
    }

    override fun getContentViewResId() = R.layout.fragment_home

    private fun search(key: String) {

    }
}