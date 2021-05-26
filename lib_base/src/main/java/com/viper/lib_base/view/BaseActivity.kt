package com.viper.lib_base.view

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
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

//    //使状态栏透明
//    private fun makeStatusBarTransparent() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            val option =
//                window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            window.decorView.systemUiVisibility = option
//            window.statusBarColor = Color.TRANSPARENT
//        }
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//    }
//
//    //使状态栏的图标呈深色
//    private fun makeStatusBarIconDark() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val option = window.decorView.systemUiVisibility
//            window.decorView.systemUiVisibility = option or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//            window.statusBarColor = Color.parseColor("#80EEEEEE")
//        }
//    }
}