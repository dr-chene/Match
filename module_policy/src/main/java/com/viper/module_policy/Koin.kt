package com.viper.module_policy

import com.viper.lib_net.article.ArticleViewModel
import com.viper.module_policy.adapter.PolicyRecyclerViewAdapter
import com.viper.module_policy.remote.PolicyService
import com.viper.module_policy.repository.PolicyRepository
import com.viper.module_policy.viewmodel.PolicyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * created by viper on 2021/5/26
 * desc
 */
val policyModule = module {
    single { PolicyRecyclerViewAdapter() }
    single { get<Retrofit>().create(PolicyService::class.java) }
    single { PolicyRepository(get()) }
    viewModel { PolicyViewModel(get()) }
}