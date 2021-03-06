package com.viper.module_expert

import com.viper.module_article.article.Article
import com.viper.module_expert.adapter.Expert2ArticleRecyclerViewAdapter
import com.viper.module_expert.adapter.Expert2RecyclerViewAdapter
import com.viper.module_expert.bean.Expert2
import com.viper.module_expert.remote.Expert2ArticleService
import com.viper.module_expert.remote.Expert2Service
import com.viper.module_expert.repository.Expert2ArticleRepository
import com.viper.module_expert.repository.Expert2Repository
import com.viper.module_expert.viewmodel.Expert2ArticleViewModel
import com.viper.module_expert.viewmodel.Expert2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * created by viper on 2021/5/26
 * desc
 */
val expertModule = module {
    single { Expert2ArticleRecyclerViewAdapter() }
    single { Expert2RecyclerViewAdapter() }
    single { get<Retrofit>().create(Expert2Service::class.java) }
    single { Expert2Repository(get()) }
    viewModel { Expert2ViewModel(get()) }
    single { get<Retrofit>().create(Expert2ArticleService::class.java) }
    single { Expert2ArticleRepository(get()) }
    viewModel { Expert2ArticleViewModel(get()) }
}