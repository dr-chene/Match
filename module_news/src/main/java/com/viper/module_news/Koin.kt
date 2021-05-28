package com.viper.module_news

import com.viper.module_news.adapter.NewsRecyclerViewAdapter
import com.viper.module_news.remote.NewsService
import com.viper.module_news.repository.NewsRepository
import com.viper.module_news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * created by viper on 2021/5/26
 * desc
 */
val newsModule = module {
    single { get<Retrofit>().create(NewsService::class.java) }
    single { NewsRepository(get()) }
    factory { NewsRecyclerViewAdapter() }
    viewModel { NewsViewModel(get()) }
}