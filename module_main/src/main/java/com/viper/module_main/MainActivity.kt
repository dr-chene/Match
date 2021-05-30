package com.viper.module_main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.viper.lib_base.view.BaseActivity
import com.viper.module_drawer.DrawerFragment
import com.viper.module_main.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onInitView() {
        binding.main2ViewPager.apply {
            adapter = object : FragmentStateAdapter(this@MainActivity) {
                override fun getItemCount() = 2

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> DrawerFragment()
                        else -> MainFragment()
                    }
                }

            }
        }
        binding.main2ViewPager.setCurrentItem(1, false)
    }

    override fun onInitAction() {}

    override fun getContentViewResId() = R.layout.activity_main

    fun navToDrawer(){
        binding.main2ViewPager.currentItem = 0
    }

    fun navToMain(){
        binding.main2ViewPager.currentItem = 1
    }
}