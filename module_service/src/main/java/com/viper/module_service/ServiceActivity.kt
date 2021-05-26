package com.viper.module_service

import com.viper.lib_base.view.BaseActivity
import com.viper.module_service.adapter.ServiceRecyclerViewAdapter
import com.viper.module_service.databinding.ActivityServiceBinding
import com.viper.module_service.viewmodel.ServiceViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServiceActivity : BaseActivity<ActivityServiceBinding>() {

    private val viewModel by viewModel<ServiceViewModel>()
    private val adapter by inject<ServiceRecyclerViewAdapter>()

    override fun onInitView() {
        binding.serviceChipAll.isChecked = true
        binding.serviceRv.adapter = adapter
    }

    override fun onInitAction() {
        binding.serviceIcBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun getContentViewResId() = R.layout.activity_service
}