package com.viper.module_tech

import com.viper.module_tech.adapter.TechRecyclerViewAdapter
import com.viper.module_tech.remote.TechService
import com.viper.module_tech.repository.TechRepository
import com.viper.module_tech.viewmodel.TechViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * created by viper on 2021/5/26
 * desc
 */
val techModule = module {
    single { TechRecyclerViewAdapter() }
    single { get<Retrofit>().create(TechService::class.java) }
    single { TechRepository(get()) }
    viewModel { TechViewModel(get()) }
}