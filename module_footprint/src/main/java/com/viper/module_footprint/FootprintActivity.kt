package com.viper.module_footprint

import com.viper.lib_base.view.BaseActivity
import com.viper.module_footprint.databinding.ActivityFootprintBinding
import com.viper.module_footprint.viewmodel.FootprintViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FootprintActivity : BaseActivity<ActivityFootprintBinding>() {

    private val viewModel by viewModel<FootprintViewModel>()

    override fun onInitView() {
        title = null
        setSupportActionBar(binding.footprintToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onInitAction() {}

    override fun getContentViewResId() = R.layout.activity_footprint

}