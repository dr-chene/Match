package com.viper.module_home

import com.viper.module_home.adapter.HomeRecyclerViewAdapter
import com.viper.module_home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val homeModule = module {
    single { (vm: HomeViewModel) -> HomeRecyclerViewAdapter(vm) }
    viewModel { HomeViewModel() }
}