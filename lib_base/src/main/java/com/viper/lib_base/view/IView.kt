package com.viper.lib_base.view

/**
 * created by viper on 2021/5/23
 * desc
 */
interface IView {

    fun onInitView()

    fun onInitAction()

    fun onSubscribe(){}

    fun getContentViewResId(): Int
}