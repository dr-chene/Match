package com.viper.module_home

import com.viper.lib_base.view.BaseFragment
import com.viper.module_home.adapter.Home4RecyclerViewAdapter
import com.viper.module_home.bean.ServiceProcess
import com.viper.module_home.databinding.FragmentHome4Binding
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHome4Binding>() {

    //    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by inject<Home4RecyclerViewAdapter>()
    private val lists by lazy {
        arrayListOf(
            ServiceProcess("01.", "受理与委托"),
            ServiceProcess("02.", "论证与审核"),
            ServiceProcess("03.", "签订合同/协议"),
            ServiceProcess("04.", "平台发布技术\n消息/宣传推广"),
            ServiceProcess("05.", "技术项目推介"),
            ServiceProcess("06.", "技术成果评价"),
            ServiceProcess("07.", "技术转化对接"),
            ServiceProcess("08.", "技术评估定价"),
            ServiceProcess("09.", "协助签署技术\n交易合同"),
            ServiceProcess("10.", "协助监督交易履行"),
            ServiceProcess("11.", "项目产业化跟进")
        )
    }

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
        binding.homeRv.adapter = adapter
        adapter.submitList(lists)
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
//        binding.homeSearchButton.setOnClickListener {
//            "功能暂未实现".showToast()
//        }
    }

    override fun getContentViewResId() = R.layout.fragment_home4

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