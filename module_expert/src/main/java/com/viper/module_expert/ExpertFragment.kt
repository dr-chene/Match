package com.viper.module_expert

import android.content.Intent
import android.util.Log
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.viper.lib_base.VerticalItemDecoration
import com.viper.lib_base.dip2px
import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.bean.Article
import com.viper.module_expert.adapter.Expert2ArticleRecyclerViewAdapter
import com.viper.module_expert.adapter.Expert2RecyclerViewAdapter
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.databinding.FragmentExpert2Binding
import com.viper.module_expert.viewmodel.Expert2ArticleViewModel
import com.viper.module_expert.viewmodel.Expert2ViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ExpertFragment : BaseFragment<FragmentExpert2Binding>() {

    private val expertViewModel by viewModel<Expert2ViewModel>()
    private val articleViewModel by viewModel<Expert2ArticleViewModel>()
    private var cate = "专题"
    private val topics = arrayListOf<Article>()
    private val hotspots = arrayListOf<Article>()
    private val articleAdapter by inject<Expert2ArticleRecyclerViewAdapter> { parametersOf(this::select) }
    private val expertAdapter by inject<Expert2RecyclerViewAdapter> { parametersOf(this::blog) }

    override fun onInitView() {
        binding.expert2Header.expert2RvArticle.adapter = articleAdapter
        binding.expert2RvExpert.adapter = expertAdapter
        binding.expert2RvExpert.addItemDecoration(VerticalItemDecoration(dip2px(10F, this.requireContext())))
    }

    override fun onInitAction() {
        binding.expert2Header.expert2Tab.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { change(it.position) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        binding.expert2Srl.setOnRefreshListener {
            refresh()
        }
        binding.expert2Srl.isRefreshing = true
        refresh()
    }

    override fun getContentViewResId() = R.layout.fragment_expert2

    override fun onSubscribe() {
        articleViewModel.lists.observe(this) {
            if (cate == "专题") {
                if (topics.isEmpty()) {
                    topics.addAll(if (it.size > 5) it.subList(0, 5) else it)
                }
                articleAdapter.submitList(topics)
            } else {
                if (hotspots.isEmpty()) hotspots.addAll(if (it.size > 5) it.subList(0, 5) else it)
                articleAdapter.submitList(hotspots)
            }
        }
        expertViewModel.isRefreshing.observe(this) {
            binding.expert2Srl.isRefreshing = it
        }
        expertViewModel.experts.observe(this) {
            expertAdapter.submitList(it)
        }
    }

    private fun change(position: Int) {
        when (position) {
            0 -> {
                cate = "专题"
            }
            1 -> {
                cate = "咨询热点"
            }
        }
        articleViewModel.refresh(cate)
    }

    private fun refresh() {
        expertViewModel.refresh()
        articleViewModel.refresh(cate)
    }

    private fun select(article: Article) {
        val expert = Expert2("is", "is", "is", "is", listOf(article), true)
        Log.d("TAG_", "select: $expert")
        Intent(this.context, DetailActivity::class.java).apply {
            putExtra("expert", expert)
            startActivity(this)
        }
    }

    private fun blog(expert: Expert2) {
        Intent(this.context, DetailActivity::class.java).apply {
            putExtra("expert", expert)
            startActivity(this)
        }
    }
}