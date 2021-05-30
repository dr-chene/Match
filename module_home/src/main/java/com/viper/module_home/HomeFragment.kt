package com.viper.module_home

import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.showToast
import com.viper.module_home.adapter.HomeRecyclerViewAdapter
import com.viper.module_home.databinding.FragmentHomeBinding
import com.viper.module_home.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by inject<HomeRecyclerViewAdapter> { parametersOf(viewModel) }

    override fun onInitView() {
        binding.homeRv.adapter = adapter
        binding.homeSrl.setOnRefreshListener {
            "功能未实现".showToast()
            binding.homeSrl.isRefreshing = false
        }
    }

    override fun onInitAction() {}

    override fun getContentViewResId() = R.layout.fragment_home

    override fun onSubscribe() {
        viewModel.lists.observe(this) {
            adapter.submitList(it)
        }
    }
}