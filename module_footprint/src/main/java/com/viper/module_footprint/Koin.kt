package com.viper.module_footprint

import com.viper.module_footprint.viewmodel.FootprintViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val footprintModule = module {
    viewModel { FootprintViewModel() }
}