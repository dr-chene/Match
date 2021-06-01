package com.viper.module_policy.viewmodel

import com.viper.lib_base.BaseViewModel
import com.viper.module_article.article.ArticleViewModel
import com.viper.module_policy.remote.PolicyService
import com.viper.module_policy.repository.PolicyRepository

/**
 * created by viper on 2021/5/26
 * desc
 */
class PolicyViewModel(
    repository: PolicyRepository
): ArticleViewModel<PolicyService, PolicyRepository>(repository)