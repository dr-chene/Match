package com.viper.module_main

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.module_login.LoginActivity
import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.MmkvUtils
import com.viper.lib_net.showToast
import com.viper.lib_net.token
import com.viper.module_expert.ExpertFragment
import com.viper.module_home.HomeFragment
import com.viper.module_main.databinding.FragmentMainBinding
import com.viper.module_news.NewsFragment
import com.viper.module_policy.PolicyFragment
import com.viper.module_policy_tech.PolicyTechFragment
import com.viper.module_service.ServiceFragment
import com.viper.module_tech.TechFragment
import com.viper.module_trade.TradeFragment

/**
 * created by viper on 2021/5/30
 * desc
 */
class MainFragment : BaseFragment<FragmentMainBinding>() {
    private var select = R.id.nav_home

    override fun onInitView() {
        token = MmkvUtils.getToken()
        binding.mainViewPager.apply {
            isUserInputEnabled = false
            adapter = object : FragmentStateAdapter(this@MainFragment) {
                override fun getItemCount() = 5

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> HomeFragment()
                        1 -> TradeFragment()
                        2 -> NewsFragment()
                        3 -> ServiceFragment()
                        4 -> PolicyTechFragment()
                        else -> HomeFragment()
                    }
                }

            }
        }
    }

    override fun onInitAction() {
        binding.mainNavBottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    nav(0, R.id.nav_home)
                    true
                }
                R.id.nav_trade -> {
                    nav(1, R.id.nav_trade)
                    true
                }
                R.id.nav_news -> {
                    nav(2, R.id.nav_news)
                    true
                }
                R.id.nav_service -> {
                    nav(3, R.id.nav_service)
                    true
                }
                R.id.nav_policy_tech -> {
                    nav(4, R.id.nav_policy_tech)
                    true
                }
                else -> false
            }
        }
        binding.mainToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.main_exit -> {
                    MmkvUtils.clear()
                    "退出登录成功".showToast()
                    nav(0, R.id.nav_home)
                    binding.mainNavBottom.selectedItemId = R.id.nav_home
                    true
                }
                else -> false
            }
        }
        binding.mainAvatar.setOnClickListener {
            (activity as MainActivity).navToDrawer()
        }
    }

    override fun getContentViewResId() = R.layout.fragment_main

    private fun nav(pos: Int, id: Int) {
        if (pos > 0 && MmkvUtils.getToken() == null) {
            "请登录后查看".showToast()
            startActivity(Intent(this.context, LoginActivity::class.java))
            return
        }
        binding.mainViewPager.setCurrentItem(pos, false)
        binding.mainTitle.text = when (pos) {
            1 -> "交易中心"
            2 -> "信息资料"
            3 -> "服务方案"
            4 -> "政策标准"
            else -> null
        }
        select = id
    }

    override fun onStop() {
        super.onStop()
        binding.mainNavBottom.selectedItemId = select
    }
}