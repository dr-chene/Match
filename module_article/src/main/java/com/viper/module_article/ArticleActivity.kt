package com.viper.module_article

import com.viper.lib_base.view.BaseActivity
import com.viper.module_article.article.Article
import com.viper.module_article.databinding.ActivityArticleBinding

class ArticleActivity : BaseActivity<ActivityArticleBinding>() {

    override fun onInitView() {
        title = null
        val article = intent.getSerializableExtra("article") as Article
        binding.article = article
        setSupportActionBar(binding.articleToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onInitAction() {}

    override fun getContentViewResId() = R.layout.activity_article
}