package com.viper.module_home

import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.showToast
import com.viper.module_home.adapter.HomeRecyclerViewAdapter
import com.viper.module_home.databinding.FragmentHome3Binding
import com.viper.module_home.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHome3Binding>() {

//    private val viewModel by viewModel<HomeViewModel>()
//    private val adapter by inject<HomeRecyclerViewAdapter>()

    override fun onInitView() {
//        binding.homeRv.adapter = adapter
//        binding.homeSrl.setOnRefreshListener {
//            "功能未实现".showToast()
//            binding.homeSrl.isRefreshing = false
//        }
//        viewModel.getCate()
//        (binding.homeHeader.homeDateSelect.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, arrayListOf("全部", "24小时内", "一周内", "一个月内", "去年"))
//        )
    }

    override fun onInitAction() {
//        binding.homeHeader.apply {
//            homeText.setOnClickListener {
//                "功能暂未实现".showToast()
//                val key = homeSearchBar.text.toString()
//                val cate = homeCateSelectText.text.toString()
//                val start = homeDateStart.text.toString()
//                val end = homeDateEnd.text.toString()
//                if (key.isNotBlank()) {
//                    if (cate.isNotBlank()) {
//                        if (start.isNotBlank() && end.isNotBlank()) viewModel.getArticles(
//                            key,
//                            cate,
//                            start,
//                            end
//                        )
//                        else viewModel.getArticles(key, cate)
//                    } else viewModel.getArticles(key)
//                } else if (cate.isNotBlank()) {
//                    viewModel.getArticlesByCate(cate)
//                } else if (start.isNotBlank() && end.isNotBlank()) viewModel.getArticlesByDate(
//                    start,
//                    end
//                ) else "请完善相关参数进行搜索".showToast()
//            }
//        }
        binding.homeSearchButton.setOnClickListener {
            "功能暂未实现".showToast()
        }
    }

    override fun getContentViewResId() = R.layout.fragment_home3

    override fun onSubscribe() {
//        viewModel.lists.observe(this) {
//            adapter.submitList(it)
//        }
//        viewModel.cate.observe(this){
//            (binding.homeHeader.homeCateSelect.editText as AutoCompleteTextView).setAdapter(
//                ArrayAdapter(this.requireContext(), R.layout.list_item, it)
//            )
//        }
    }
}