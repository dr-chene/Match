package com.viper.module_policy.repository

import com.viper.lib_net.article.ArticleRepository
import com.viper.module_policy.remote.PolicyService

/**
 * created by viper on 2021/5/28
 * desc
 */
class PolicyRepository(
    api: PolicyService
): ArticleRepository<PolicyService>(api)