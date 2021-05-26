package com.viper.module_expert

import com.viper.module_expert.viewmodel.ExpertViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val expertModule = module {
    viewModel { ExpertViewModel() }
}