package com.viper.module_tech

import com.viper.lib_base.view.BaseFragment
import com.viper.module_tech.databinding.FragmentTechBinding
import com.viper.module_tech.viewmodel.TechViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TechFragment : BaseFragment<FragmentTechBinding>() {

    private val viewModel by viewModel<TechViewModel>()

    override fun onInitView() {

    }

    override fun onInitAction() {

    }

    override fun getContentViewResId() = R.layout.fragment_tech

}