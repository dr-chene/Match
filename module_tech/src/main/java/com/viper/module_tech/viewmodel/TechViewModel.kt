package com.viper.module_tech.viewmodel

import com.viper.lib_net.article.ArticleViewModel
import com.viper.module_tech.remote.TechService
import com.viper.module_tech.repository.TechRepository

/**
 * created by viper on 2021/5/26
 * desc
 */
class TechViewModel(
    repository: TechRepository
) : ArticleViewModel<TechService>(repository)