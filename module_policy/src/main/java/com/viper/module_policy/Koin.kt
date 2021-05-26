package com.viper.module_policy

import com.viper.module_policy.viewmodel.PolicyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val policyModule = module {
    viewModel { PolicyViewModel() }
}