package com.viper.module_info

import com.viper.lib_base.view.BaseActivity
import com.viper.module_info.databinding.ActivityInfoBinding
import com.viper.module_info.viewmodel.InfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class InfoActivity : BaseActivity<ActivityInfoBinding>() {

    private val viewModel by viewModel<InfoViewModel>()

    override fun onInitView() {

    }

    override fun onInitAction() {
        binding.infoIcBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun getContentViewResId() = R.layout.activity_info
}