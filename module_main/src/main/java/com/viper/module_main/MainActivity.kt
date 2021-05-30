package com.viper.module_main

import android.app.ActivityOptions
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.module_login.LoginActivity
import com.viper.lib_base.view.BaseActivity
import com.viper.lib_net.MmkvUtils
import com.viper.lib_net.showToast
import com.viper.lib_net.token
import com.viper.module_drawer.DrawerActivity
import com.viper.module_expert.ExpertFragment
import com.viper.module_home.HomeFragment
import com.viper.module_main.databinding.ActivityMainBinding
import com.viper.module_news.NewsFragment
import com.viper.module_policy.PolicyFragment
import com.viper.module_tech.TechFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var select = R.id.nav_home

    override fun onInitView() {
        title = null
        setSupportActionBar(binding.mainToolbar)
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
    }

    override fun onInitAction() {
        binding.mainNavBottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    nav(0, R.id.nav_home)
                    true
                }
                R.id.nav_info -> {
                    nav(1, R.id.nav_info)
                    true
                }
                R.id.nav_policy -> {
                    nav(2, R.id.nav_policy)
                    true
                }
                R.id.nav_tech -> {
                    nav(3, R.id.nav_tech)
                    true
                }
                R.id.nav_expert -> {
                    nav(4, R.id.nav_expert)
                    true
                }
                else -> false
            }
        }
        binding.mainAvatar.setOnClickListener {
            startActivity(
                Intent(this, DrawerActivity::class.java),
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }
    }

    override fun getContentViewResId() = R.layout.activity_main

    private fun nav(pos: Int, id: Int) {
        if (pos > 0 && MmkvUtils.getToken() == null) {
            "请登录后查看".showToast()
            startActivity(Intent(this, LoginActivity::class.java))
            return
        }
        binding.mainViewPager.setCurrentItem(pos, false)
        binding.mainTitle.text = when (pos) {
            1 -> "信息资料"
            2 -> "政策法规"
            3 -> "技术标准"
            4 -> "专家对接"
            else -> null
        }
        select = id
    }

    override fun onRestart() {
        super.onRestart()
        binding.mainNavBottom.selectedItemId = select
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.main_exit) {
            MmkvUtils.clear()
            "退出登录成功".showToast()
            nav(0, R.id.nav_home)
            true
        } else super.onOptionsItemSelected(item)
    }
}