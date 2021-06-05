package com.viper.module_service

import com.viper.module_service.adapter.Service4RecyclerViewAdapter
import com.viper.module_service.adapter.ServiceRecyclerViewAdapter
import com.viper.module_service.viewmodel.ServiceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val serviceModule = module {
//    single { ServiceRecyclerViewAdapter() }
    single { Service4RecyclerViewAdapter() }
//    viewModel { ServiceViewModel() }
}