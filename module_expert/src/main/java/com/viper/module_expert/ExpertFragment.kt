package com.viper.module_expert

import android.app.Activity
import android.content.Intent
import android.view.View
import com.viper.lib_base.VerticalItemDecoration
import com.viper.lib_base.dip2px
import com.viper.lib_base.view.BaseFragment
import com.viper.module_expert.adapter.Expert2ArticleRecyclerViewAdapter
import com.viper.module_expert.adapter.Expert2RecyclerViewAdapter
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.databinding.FragmentExpert3Binding
import com.viper.module_expert.viewmodel.Expert2ArticleViewModel
import com.viper.module_expert.viewmodel.Expert2ViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ExpertFragment : BaseFragment<FragmentExpert3Binding>() {

    private val expertViewModel by viewModel<Expert2ViewModel>()
    private val articleViewModel by viewModel<Expert2ArticleViewModel>()
    private var cate = "专题"
    private val articleAdapter by inject<Expert2ArticleRecyclerViewAdapter>()
    private val expertAdapter by inject<Expert2RecyclerViewAdapter>()

    override fun onInitView() {
        binding.expert3Header.expert3RvArticle.adapter = articleAdapter
        binding.expert3RvExpert.adapter = expertAdapter
        binding.expert3RvExpert.addItemDecoration(
            VerticalItemDecoration(
                dip2px(
                    10F,
                    this.requireContext()
                )
            )
        )
        binding.expert3Header.expert3Topic.isChecked = true
    }

    override fun onInitAction() {
        binding.expert3Header.expert3Chips.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.expert3_topic -> {
                    articleViewModel.refresh("专题")
                    cate = "专题"
                }
                R.id.expert3_hotspot -> {
                    articleViewModel.refresh("咨询热点")
                    cate = "咨询热点"
                }
            }
        }
        binding.expert3Srl.setOnRefreshListener {
            refresh()
        }
        binding.expert3Srl.isRefreshing = true
        refresh()
    }

    override fun getContentViewResId() = R.layout.fragment_expert3

    override fun onSubscribe() {
        articleViewModel.lists.observe(this) {
            articleAdapter.submitList(if (it.size > 5) it.subList(0, 5) else it)
        }
        expertViewModel.isRefreshing.observe(this) {
            binding.expert3Srl.isRefreshing = it
        }
        expertViewModel.experts.observe(this) {
            expertAdapter.submitList(it)
            binding.expertEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun refresh() {
        expertViewModel.refresh()
        articleViewModel.refresh(cate)
    }
}