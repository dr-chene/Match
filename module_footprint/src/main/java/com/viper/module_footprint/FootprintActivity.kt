package com.viper.module_footprint

import com.viper.lib_base.view.BaseActivity
import com.viper.module_footprint.databinding.ActivityFootprintBinding
import com.viper.module_footprint.viewmodel.FootprintViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FootprintActivity : BaseActivity<ActivityFootprintBinding>() {

    private val viewModel by viewModel<FootprintViewModel>()

    override fun onInitView() {

    }

    override fun onInitAction() {
        binding.footprintIcBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun getContentViewResId() = R.layout.activity_footprint

}