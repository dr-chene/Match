package com.viper.module_policy_tech

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.viper.lib_base.view.BaseFragment
import com.viper.module_policy.PolicyFragment
import com.viper.module_policy_tech.databinding.FragmentPolicyTechBinding
import com.viper.module_tech.TechFragment

class PolicyTechFragment : BaseFragment<FragmentPolicyTechBinding>() {
    override fun onInitView() {
        binding.policyTechViewPager.apply {
            isUserInputEnabled = false
            adapter = object : FragmentStateAdapter(this@PolicyTechFragment) {
                override fun getItemCount() = 2

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> PolicyFragment()
                        else -> TechFragment()
                    }
                }

            }
        }
    }

    override fun onInitAction() {
        binding.policyTechTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { binding.policyTechViewPager.setCurrentItem(it.position, false) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    override fun getContentViewResId() = R.layout.fragment_policy_tech

}