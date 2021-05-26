package com.viper.module_tech

import com.viper.module_tech.viewmodel.TechViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val techModule = module {
    viewModel { TechViewModel() }
}