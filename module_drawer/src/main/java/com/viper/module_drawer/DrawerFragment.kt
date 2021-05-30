package com.viper.module_drawer

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ImageView
import com.example.module_login.LoginActivity
import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.MmkvUtils
import com.viper.lib_net.showToast
import com.viper.module_drawer.databinding.FragmentDrawerBinding
import com.viper.module_footprint.FootprintActivity
import com.viper.module_info.InfoActivity
import com.viper.module_service.ServiceActivity

class DrawerFragment : BaseFragment<FragmentDrawerBinding>() {

    override fun onInitView() {}

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
            getHeaderView(0).findViewById<ImageView>(R.id.drawer_avatar).setOnClickListener {
                navActivity<LoginActivity>(false)
            }
        }
    }

    override fun getContentViewResId() = R.layout.fragment_drawer

    private inline fun <reified T : Activity> navActivity(needLogin: Boolean = true) {
        val isLogin = MmkvUtils.getToken() != null
        if (needLogin == isLogin) {
            startActivity(Intent(this.context, T::class.java))
        }
        if (needLogin && !isLogin) {
            "请登录后查看".showToast()
            startActivity(Intent(this.context, LoginActivity::class.java))
        }
    }
}