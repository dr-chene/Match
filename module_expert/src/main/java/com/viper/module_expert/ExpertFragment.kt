package com.viper.module_expert

import com.viper.lib_base.view.BaseFragment
import com.viper.module_expert.databinding.FragmentExpertBinding
import com.viper.module_expert.viewmodel.ExpertViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExpertFragment : BaseFragment<FragmentExpertBinding>() {

    private val viewModel by viewModel<ExpertViewModel>()

    override fun onInitView() {
        loadExpert()
    }

    override fun onInitAction() {
        binding.expertFabChange.setOnClickListener {

        }
    }

    override fun getContentViewResId() = R.layout.fragment_expert

    private fun loadExpert() {

    }

    private fun loadAgency() {

    }
}