package com.viper.lib_base.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * created by viper on 2021/5/23
 * desc
 */
abstract class BaseActivity<T: ViewDataBinding>: AppCompatActivity(), IView {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getContentViewResId())
        onInitView()
        onInitAction()
        onSubscribe()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId == android.R.id.home){
            onBackPressed()
            true
        } else super.onOptionsItemSelected(item)
    }
}