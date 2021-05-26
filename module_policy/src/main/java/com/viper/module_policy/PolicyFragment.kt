package com.viper.module_policy

import com.viper.lib_base.view.BaseFragment
import com.viper.module_policy.databinding.FragmentPolicyBinding
import com.viper.module_policy.viewmodel.PolicyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PolicyFragment : BaseFragment<FragmentPolicyBinding>() {

    private val viewModel by viewModel<PolicyViewModel>()

    override fun onInitView() {

    }

    override fun onInitAction() {

    }

    override fun getContentViewResId() = R.layout.fragment_policy

}