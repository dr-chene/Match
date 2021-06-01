package com.viper.module_expert

import android.util.Log
import android.view.View
import com.viper.lib_base.VerticalItemDecoration
import com.viper.lib_base.dip2px
import com.viper.lib_base.view.BaseActivity
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.databinding.ActivityDetailBinding
import com.viper.module_news.adapter.NewsRecyclerViewAdapter
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private val adapter by inject<NewsRecyclerViewAdapter>()

    override fun onInitView() {
        title = null
        setSupportActionBar(binding.detailToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val expert = intent.getSerializableExtra("expert") as Expert2
        binding.expert = expert
        binding.detailHead.expert = expert
        binding.detailRv.adapter = adapter
        binding.detailRv.addItemDecoration(VerticalItemDecoration(dip2px(10F, this)))
        expert.blogs.let {
            adapter.submitList(it)
            Log.d("TAG_", "onInitView: ${it.size}")
            Log.d("TAG_", "onInitView: ${it.isEmpty()}")
            binding.detailEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onInitAction() {

    }

    override fun getContentViewResId() = R.layout.activity_detail

}