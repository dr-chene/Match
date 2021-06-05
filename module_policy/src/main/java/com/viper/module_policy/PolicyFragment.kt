package com.viper.module_policy

import com.viper.lib_base.view.BaseFragment
import com.viper.module_policy.databinding.FragmentPolicy4Binding

class PolicyFragment : BaseFragment<FragmentPolicy4Binding>() {

//    private val viewModel by viewModel<PolicyViewModel>()
//    private val adapter by inject<PolicyRecyclerViewAdapter>()
//    private val categories by lazy {
//        listOf("国家政策", "地方政策", "国际政策", "头条政策", "最新政策", "政策解读")
//    }
//    private val countries by lazy {
//        listOf("东亚", "新加坡","马来西亚","印度尼西亚","缅甸","泰国","老挝","柬埔寨","越南","文莱","菲律宾")
//    }
//    private val types by lazy {
//        listOf("整车", "车厢", "车门", "车型", "汽车零部件", "刹车系统配件")
//    }
//    private val fields by lazy {
//        listOf("知识产权","税法","新能源","标准")
//    }
//    private val issues by lazy {
//        listOf(
//            "中央人民政府",
//            "公安部",
//            "工业和信息化部",
//            "中国机械工业联合会",
//            "民政部",
//            "国家标准化管理委员会",
//            "国家发展和改革委员会",
//            "海关总署",
//            "科学技术部",
//            "世界汽车工业国际协会"
//        )
//    }

    override fun onInitView() {
//        binding.policy3Rv.adapter = adapter
//        binding.policy3Rv.addItemDecoration(
//            VerticalItemDecoration(
//                dip2px(
//                    10F,
//                    this.requireContext()
//                )
//            )
//        )
//        initCate()
//        (binding.policySelectCountry.policySelectInput.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, countries)
//        )
//        (binding.policySelectType.policySelectInput.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, types)
//        )
//        (binding.policySelectField.policySelectInput.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, fields)
//        )
//        (binding.policySelectIssue.policySelectInput.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, issues)
//        )
    }

    override fun onInitAction() {
//        binding.policy3Header.apply {
//            policy2BtnSearch.setOnClickListener {
//                val cate = policy2SelectText.text.toString()
//                val key = policy2SearchText.text.toString()
//                if (cate.isBlank()) {
//                    "请选择要搜索的类别".showToast()
//                    return@setOnClickListener
//                }
//                refresh(cate, key)
//            }
//        }
//        binding.policy3Header.policy2SelectText.addTextChangedListener {
//            refresh(it.toString())
//        }
//        binding.policy3Srl.setOnRefreshListener {
//            val cate = binding.policy3Header.policy2SelectText.text.toString()
//            if (cate.isBlank()) refresh(categories.random())
//            else refresh(cate)
//        }
//        binding.policy3TvSearch.setOnClickListener {
//            "功能暂未实现".showToast()
//        }
//        refresh(categories.random())
    }

    override fun getContentViewResId() = R.layout.fragment_policy4

    override fun onSubscribe() {
//        viewModel.isRefreshing.observe(this) {
//            binding.policy3Srl.isRefreshing = it
//        }
//        viewModel.lists.observe(this) {
//            adapter.submitList(it)
//            binding.policyEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
//        }
    }

//    private fun refresh(cate: String, key: String? = null) {
//        if (!key.isNullOrBlank()) viewModel.refresh(cate, key)
//        else viewModel.refresh(cate)
//    }
//
//    private fun initCate() {
//        (binding.policy3Header.policy2Select.editText as AutoCompleteTextView).setAdapter(
//            ArrayAdapter(this.requireContext(), R.layout.list_item, categories)
//        )
//    }
}