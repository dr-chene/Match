package com.viper.module_news

import android.view.View
import com.google.android.material.tabs.TabLayout
import com.viper.lib_base.VerticalItemDecoration
import com.viper.lib_base.dip2px
import com.viper.lib_base.view.BaseFragment
import com.viper.module_news.adapter.NewsRecyclerViewAdapter
import com.viper.module_news.databinding.FragmentNews3Binding
import com.viper.module_news.databinding.FragmentNewsBinding
import com.viper.module_news.viewmodel.NewsViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNews3Binding>() {

    private val viewModel by viewModel<NewsViewModel>()
    private val adapter by inject<NewsRecyclerViewAdapter>()
    private var cate = IAE

    override fun onInitView() {
        binding.newsRv.adapter = adapter
        binding.newsRv.addItemDecoration(VerticalItemDecoration(dip2px(10F, this.requireContext())))
    }

    override fun onInitAction() {
        binding.newsTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    val t = when (it.position) {
                        0 -> IAE
                        1 -> AREA
                        2 -> ENTERPRISE
                        else -> PAM
                    }
                    if (t != cate) {
                        cate = t
                        refresh(cate)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        binding.newsSrl.setOnRefreshListener {
            refresh(cate)
        }
        binding.newsSearchBtn.setOnClickListener {
            val key = binding.newsSearch.text.toString()
            if (key.isNotBlank()) refresh(cate, key)
            else refresh(cate)
        }
    }

    override fun getContentViewResId() = R.layout.fragment_news3

    override fun onSubscribe() {
        viewModel.lists.observe(this) {
            adapter.submitList(it)
            binding.newsEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
        }
        viewModel.isRefreshing.observe(this) {
            if (it && !binding.newsSrl.isRefreshing) {
                binding.newsSrl.isRefreshing = true
            } else if (!it && binding.newsSrl.isRefreshing) {
                binding.newsSrl.isRefreshing = false
            }
        }
        refresh(cate)
    }

    private fun refresh(cate: String, key: String? = null) {
        viewModel.refresh(cate, key)
    }

    companion object {
        private const val IAE = "进出口及其产销数据统计"
        private const val AREA = "地区"
        private const val ENTERPRISE = "企业动态"
        private const val PAM = "进出口产销"
    }
}