package com.viper.module_tech

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.widget.addTextChangedListener
import com.viper.lib_base.VerticalItemDecoration
import com.viper.lib_base.dip2px
import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.showToast
import com.viper.module_tech.adapter.TechRecyclerViewAdapter
import com.viper.module_tech.databinding.FragmentTech2Binding
import com.viper.module_tech.viewmodel.TechViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class TechFragment : BaseFragment<FragmentTech2Binding>() {

    private val viewModel by viewModel<TechViewModel>()
    private val adapter by inject<TechRecyclerViewAdapter>()
    private val categories by lazy {
        listOf("团体标准", "标准动态", "国家标准", "国际标准")
    }

    override fun onInitView() {
        binding.tech2Rv.adapter = adapter
        binding.tech2Rv.addItemDecoration(VerticalItemDecoration(dip2px(10F, this.requireContext())))
        initCate()
    }

    override fun onInitAction() {
        binding.tech2Header.apply {
            tech2BtnSearch.setOnClickListener {
                val cate = tech2SelectText.text.toString()
                val key = tech2SearchText.text.toString()
                if (cate.isBlank()) {
                    "请选择要搜索的类别".showToast()
                    return@setOnClickListener
                }
                refresh(cate, key)
            }
        }
        binding.tech2Header.tech2SelectText.addTextChangedListener {
            refresh(it.toString())
        }
        binding.tech2Srl.setOnRefreshListener {
            val cate = binding.tech2Header.tech2SelectText.text.toString()
            if (cate.isBlank()) refresh(categories.random())
            else refresh(cate)
        }
        refresh(categories.random())
    }

    override fun getContentViewResId() = R.layout.fragment_tech2

    override fun onSubscribe() {
        viewModel.isRefreshing.observe(this) {
            binding.tech2Srl.isRefreshing = it
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
        (binding.tech2Header.tech2Select.editText as AutoCompleteTextView).setAdapter(
            ArrayAdapter(this.requireContext(), R.layout.list_item, categories)
        )
    }
}