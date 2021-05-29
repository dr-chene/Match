package com.viper.module_expert.viewmodel

import com.viper.lib_net.article.ArticleViewModel
import com.viper.module_expert.remote.Expert2ArticleService
import com.viper.module_expert.repository.Expert2ArticleRepository

/**
 * created by viper on 2021/5/29
 * desc
 */
class Expert2ArticleViewModel(
    repository: Expert2ArticleRepository
) : ArticleViewModel<Expert2ArticleService>(repository)