package com.viper.module_info

import com.viper.module_info.viewmodel.InfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val infoModule = module {
    viewModel { InfoViewModel() }
}