package com.viper.module_expert.repository

import com.viper.lib_net.article.ArticleRepository
import com.viper.module_expert.remote.Expert2ArticleService

/**
 * created by viper on 2021/5/29
 * desc
 */
class Expert2ArticleRepository(
    api: Expert2ArticleService
): ArticleRepository<Expert2ArticleService>(api)