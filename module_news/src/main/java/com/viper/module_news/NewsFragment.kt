package com.viper.module_news

import com.viper.lib_base.view.BaseFragment
import com.viper.module_news.databinding.FragmentNewsBinding
import com.viper.module_news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    private val viewModel by viewModel<NewsViewModel>()

    override fun onInitView() {

    }

    override fun onInitAction() {

    }

    override fun getContentViewResId() = R.layout.fragment_news

}