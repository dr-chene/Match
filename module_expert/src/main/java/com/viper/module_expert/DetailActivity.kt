package com.viper.module_expert

import android.util.Log
import com.viper.lib_base.view.BaseActivity
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.databinding.ActivityDetailBinding
import com.viper.module_news.adapter.NewsRecyclerViewAdapter
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private val adapter by inject<NewsRecyclerViewAdapter>()

    override fun onInitView() {
        val expert = intent.getParcelableExtra<Expert2>("expert")
        val expert2 = intent.getParcelableExtra<Expert2>("expert_is")
        Log.d("TAG_", "onInitView: $expert")
        Log.d("TAG_is", "onInitView: $expert2")
        binding.expert = expert
        binding.detailHead.expert = expert
        binding.detailRv.adapter = adapter
    }

    override fun onInitAction() {
        binding.detailIcBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun getContentViewResId() = R.layout.activity_detail

}