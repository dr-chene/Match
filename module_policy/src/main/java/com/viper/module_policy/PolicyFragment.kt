package com.viper.module_policy

import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.showToast
import com.viper.module_policy.adapter.PolicyRecyclerViewAdapter
import com.viper.module_policy.databinding.FragmentPolicy2Binding
import com.viper.module_policy.viewmodel.PolicyViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PolicyFragment : BaseFragment<FragmentPolicy2Binding>() {

    private val viewModel by viewModel<PolicyViewModel>()
    private val adapter by inject<PolicyRecyclerViewAdapter>()
    private val categories by lazy {
        listOf("国家政策", "地方政策", "国际政策", "头条政策", "最新政策", "政策解读")
    }

    override fun onInitView() {
        binding.policy2Rv.adapter = adapter
        initCate()
    }

    override fun onInitAction() {
        binding.policy2Header.apply {
            policy2BtnSearch.setOnClickListener {
                val cate = policy2SelectText.text.toString()
                val key = policy2SearchText.text.toString()
                if (cate.isBlank() ) {
                    "请选择要搜索的类别".showToast()
                    return@setOnClickListener
                }
                refresh(cate, key)
            }
        }
        binding.policy2Srl.setOnRefreshListener {
            val cate = binding.policy2Header.policy2SelectText.text.toString()
            if (cate.isBlank()) refresh(categories.random())
            else refresh(cate)
        }
        refresh(categories.random())
    }

    override fun getContentViewResId() = R.layout.fragment_policy2

    override fun onSubscribe() {
        viewModel.isRefreshing.observe(this) {
            binding.policy2Srl.isRefreshing = it
        }
        viewModel.lists.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun refresh(cate: String, key: String? = null) {
        if (!key.isNullOrBlank()) viewModel.refresh(cate, key)
        else viewModel.refresh(cate)
    }

    private fun initCate() {
        (binding.policy2Header.policy2Select.editText as AutoCompleteTextView).setAdapter(
            ArrayAdapter(this.requireContext(), R.layout.list_item, categories)
        )
    }
}