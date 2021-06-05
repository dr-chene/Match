package com.viper.module_home

import com.viper.module_article.article.ArticleService
import com.viper.module_home.adapter.Home4RecyclerViewAdapter
import com.viper.module_home.adapter.HomeRecyclerViewAdapter
import com.viper.module_home.remote.CateService
import com.viper.module_home.repository.HomeCateRepository
import com.viper.module_home.repository.HomeRepository
import com.viper.module_home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * created by viper on 2021/5/26
 * desc
 */
val homeModule = module {
//    single { HomeRecyclerViewAdapter() }
//    single { get<Retrofit>().create(ArticleService::class.java) }
//    single { HomeRepository(get()) }
//    single { get<Retrofit>().create(CateService::class.java) }
//    single { HomeCateRepository(get()) }
//    viewModel { HomeViewModel(get(), get()) }
    single { Home4RecyclerViewAdapter() }
}