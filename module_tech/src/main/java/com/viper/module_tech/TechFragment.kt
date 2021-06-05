package com.viper.module_tech

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.viper.lib_base.view.BaseFragment
import com.viper.module_tech.databinding.FragmentTech4Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TechFragment : BaseFragment<FragmentTech4Binding>() {

//    private val viewModel by viewModel<TechViewModel>()
//    private val adapter by inject<TechRecyclerViewAdapter>()
//    private val categories by lazy {
//        listOf("团体标准", "标准动态", "国家标准", "国际标准")
//    }
//    private val countries by lazy {
//        listOf("东亚", "新加坡","马来西亚","印度尼西亚","缅甸","泰国","老挝","柬埔寨","越南","文莱","菲律宾")
//    }
//    private val types by lazy {
//        listOf("整车", "车厢", "车门", "车型", "汽车零部件", "刹车系统配件")
//    }
    override fun onInitView() {
//        binding.tech3Rv.adapter = adapter
//        binding.tech3Rv.addItemDecoration(VerticalItemDecoration(dip2px(10F, this.requireContext())))
//        initCate()
//        (binding.techSelectCountry.techSelectInput.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, countries)
//        )
//        (binding.techSelectType.techSelectInput.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, types)
//        )
    }

    override fun onInitAction() {
//        binding.tech3Header.apply {
//            tech2BtnSearch.setOnClickListener {
//                val cate = tech2SelectText.text.toString()
//                val key = tech2SearchText.text.toString()
//                if (cate.isBlank()) {
//                    "请选择要搜索的类别".showToast()
//                    return@setOnClickListener
//                }
//                refresh(cate, key)
//            }
//        }
//        binding.tech3Header.tech2SelectText.addTextChangedListener {
//            refresh(it.toString())
//        }
//        binding.tech3Srl.setOnRefreshListener {
//            val cate = binding.tech3Header.tech2SelectText.text.toString()
//            if (cate.isBlank()) refresh(categories.random())
//            else refresh(cate)
//        }
//        binding.tech3TvSearch.setOnClickListener {
//            "功能暂未实现".showToast()
//        }
//        refresh(categories.random())
    }

    override fun getContentViewResId() = R.layout.fragment_tech4

    override fun onSubscribe() {
//        viewModel.isRefreshing.observe(this) {
//            binding.tech3Srl.isRefreshing = it
//        }
//        viewModel.lists.observe(this) {
//            adapter.submitList(it)
//            binding.techEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
//        }
    }

//    private fun refresh(cate: String, key: String? = null) {
//        if (!key.isNullOrBlank()) viewModel.refresh(cate, key)
//        else viewModel.refresh(cate)
//    }
//
//    private fun initCate() {
//        (binding.tech3Header.tech2Select.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, categories)
//        )
//    }
}