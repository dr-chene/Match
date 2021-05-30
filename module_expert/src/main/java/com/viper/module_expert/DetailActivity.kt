package com.viper.module_expert

import com.viper.lib_base.view.BaseActivity
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.databinding.ActivityDetailBinding
import com.viper.module_news.adapter.NewsRecyclerViewAdapter
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private val adapter by inject<NewsRecyclerViewAdapter>()

    override fun onInitView() {
        val expert = intent.getSerializableExtra("expert") as Expert2
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