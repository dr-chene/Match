package com.viper.module_drawer

import android.app.Activity
import android.content.Intent
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.widget.ImageView
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
        binding.drawerNav.apply {
            setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.drawer_my_info -> {
                        navActivity<InfoActivity>()
                        true
                    }
                    R.id.drawer_my_footprint -> {
                        navActivity<FootprintActivity>()
                        true
                    }
                    R.id.drawer_my_wallet -> {
                        "功能暂未开放".showToast()
                        true
                    }
                    R.id.drawer_my_service -> {
                        navActivity<ServiceActivity>()
                        true
                    }
                    R.id.drawer_my_commitment -> {
                        "功能暂未开放".showToast()
                        true
                    }
                    R.id.drawer_my_tools -> {
                        "功能暂未开放".showToast()
                        true
                    }
                    else -> false
                }
            }
            getHeaderView(0).findViewById<View>(R.id.drawer_exit_action).setOnClickListener {
                onBackPressed()
            }
            getHeaderView(0).findViewById<ImageView>(R.id.drawer_avatar).setOnClickListener {
                navActivity<LoginActivity>(false)
            }
        }
    }

    override fun getContentViewResId() = R.layout.activity_drawer

    private inline fun <reified T : Activity> navActivity(needLogin: Boolean = true) {
        val isLogin = MmkvUtils.getToken() != null
        if (needLogin == isLogin) {
            startActivity(Intent(this, T::class.java))
        }
        if (needLogin && !isLogin) {
            "请登录后查看".showToast()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}