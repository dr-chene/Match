package com.viper.module_drawer

import android.app.Activity
import android.content.Intent
import android.transition.Slide
import android.view.Gravity
import com.example.module_login.LoginActivity
import com.viper.lib_base.view.BaseActivity
import com.viper.lib_net.MmkvUtils
import com.viper.lib_net.showToast
import com.viper.module_drawer.databinding.ActivityDrawerBinding
import com.viper.module_footprint.FootprintActivity
import com.viper.module_info.InfoActivity
import com.viper.module_service.ServiceActivity

class DrawerActivity : BaseActivity<ActivityDrawerBinding>() {

    override fun onTrans() {
        with(window) {
            Slide(Gravity.START).let {
                enterTransition = it
                exitTransition = it
            }
        }
    }

    override fun onInitView() {

    }

    override fun onInitAction() {
        binding.drawerAvatar.setOnClickListener {
            navActivity<LoginActivity>(false)
        }
        binding.drawerMyInfo.setOnClickListener {
            navActivity<InfoActivity>()
        }
        binding.drawerMyFootprint.setOnClickListener {
            navActivity<FootprintActivity>()
        }
        binding.drawerMyWallet.setOnClickListener {
            "功能暂未开放".showToast()
        }
        binding.drawerMyService.setOnClickListener {
            navActivity<ServiceActivity>()
        }
        binding.drawerMyCommit.setOnClickListener {
            "功能暂未开放".showToast()
        }
        binding.drawerMyTools.setOnClickListener {
            "功能暂未开放".showToast()
        }
        binding.drawerExit.setOnClickListener {
            onBackPressed()
        }
    }

    override fun getContentViewResId() = R.layout.activity_drawer

    private inline fun <reified T: Activity> navActivity(needLogin: Boolean = true){
        val isLogin = MmkvUtils.getToken() != null
        if (needLogin == isLogin) {
            startActivity(Intent(this, T::class.java))
        }
        if (needLogin && !isLogin) "请先登录".showToast()
    }
}