package com.viper.module_news

import com.viper.module_news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by viper on 2021/5/26
 * desc
 */
val newsModule = module {
    viewModel { NewsViewModel() }
}