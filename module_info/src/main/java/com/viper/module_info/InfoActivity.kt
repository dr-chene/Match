package com.viper.module_info

import com.viper.lib_base.view.BaseActivity
import com.viper.module_info.databinding.ActivityInfoBinding
import com.viper.module_info.viewmodel.InfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class InfoActivity : BaseActivity<ActivityInfoBinding>() {

    private val viewModel by viewModel<InfoViewModel>()

    override fun onInitView() {
        title = null
        setSupportActionBar(binding.infoToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onInitAction() {}

    override fun getContentViewResId() = R.layout.activity_info
}