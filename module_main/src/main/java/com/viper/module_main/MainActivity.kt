package com.viper.module_main

import android.app.ActivityOptions
import android.content.Intent
import android.transition.Slide
import android.view.Gravity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.viper.lib_base.view.BaseActivity
import com.viper.lib_net.MmkvUtils
import com.viper.lib_net.token
import com.viper.module_drawer.DrawerActivity
import com.viper.module_expert.ExpertFragment
import com.viper.module_home.HomeFragment
import com.viper.module_main.databinding.ActivityMainBinding
import com.viper.module_news.NewsFragment
import com.viper.module_policy.PolicyFragment
import com.viper.module_tech.TechFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onTrans() {
//        with(window) {
//            Slide(Gravity.END).let {
//                exitTransition = it
//                reenterTransition = it
//            }
//        }
    }

    override fun onInitView() {
        token = MmkvUtils.getToken()
        binding.mainViewPager.apply {
            isUserInputEnabled = false
            adapter = object : FragmentStateAdapter(this@MainActivity) {
                override fun getItemCount() = 5

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> HomeFragment()
                        1 -> NewsFragment()
                        2 -> PolicyFragment()
                        3 -> TechFragment()
                        4 -> ExpertFragment()
                        else -> HomeFragment()
                    }
                }

            }
        }
        binding.mainToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.main_exit -> {
                    MmkvUtils.clear()
                    true
                }
                else -> false
            }
        }
    }

    override fun onInitAction() {
        binding.mainNavBottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    nav(0)
                    true
                }
                R.id.nav_info -> {
                    nav(1)
                    true
                }
                R.id.nav_policy -> {
                    nav(2)
                    true
                }
                R.id.nav_tech -> {
                    nav(3)
                    true
                }
                R.id.nav_expert -> {
                    nav(4)
                    true
                }
                else -> false
            }
        }
        binding.mainToolbar.setNavigationOnClickListener {
            startActivity(
                Intent(this, DrawerActivity::class.java),
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }
    }

    override fun getContentViewResId() = R.layout.activity_main

    private fun nav(pos: Int) {
        binding.mainViewPager.setCurrentItem(pos, false)
        binding.mainToolbar.title = when (pos) {
            1 -> "信息资料"
            2 -> "政策法规"
            3 -> "技术标准"
            4 -> "专家对接"
            else -> null
        }
    }
}