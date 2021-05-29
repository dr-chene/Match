package com.viper.module_tech.repository

import com.viper.lib_net.article.ArticleRepository
import com.viper.module_tech.remote.TechService

/**
 * created by viper on 2021/5/28
 * desc
 */
class TechRepository(
    api: TechService
) : ArticleRepository<TechService>(api)