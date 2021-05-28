package com.viper.module_home

import android.content.Intent
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import com.example.module_login.LoginActivity
import com.google.android.material.imageview.ShapeableImageView
import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.MmkvUtils
import com.viper.lib_net.showToast
import com.viper.lib_net.token
import com.viper.module_footprint.FootprintActivity
import com.viper.module_home.adapter.HomeRecyclerViewAdapter
import com.viper.module_home.databinding.FragmentHomeBinding
import com.viper.module_home.viewmodel.HomeViewModel
import com.viper.module_info.InfoActivity
import com.viper.module_service.ServiceActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by inject<HomeRecyclerViewAdapter> { parametersOf(viewModel) }

    override fun onInitView() {
        binding.homeContent.homeMain.homeRv.adapter = adapter
    }

    override fun onInitAction() {
        binding.homeContent.homeAvatar.setOnClickListener {
            binding.homeDrawer.openDrawer(Gravity.LEFT)
        }
        binding.homeNavDrawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_my_info -> {
                    startActivity(Intent(this.context, InfoActivity::class.java))
                    true
                }
                R.id.home_my_footprint -> {
                    startActivity(Intent(this.context, FootprintActivity::class.java))
                    true
                }
                R.id.home_my_wallet -> {
                    "暂不支持该服务".showToast()
                    true
                }
                R.id.home_my_service -> {
                    startActivity(Intent(this.context, ServiceActivity::class.java))
                    true
                }
                R.id.home_my_commitment -> {
                    "暂不支持该服务".showToast()
                    true
                }
                R.id.home_my_tools -> {
                    "暂不支持该服务".showToast()
                    true
                }
                else -> false
            }
        }
        binding.homeContent.homeMain.homeSrl.setOnRefreshListener {
//            viewModel.refresh()
        }
//        binding.homeContent.homeMain.homeSrl.isRefreshing = true
//        viewModel.refresh()
        binding.homeNavDrawer.getHeaderView(0).apply {
            findViewById<ShapeableImageView>(R.id.home_drawer_avatar).setOnClickListener {
                if (MmkvUtils.getToken() == null) {
                    startActivity(Intent(this.context, LoginActivity::class.java))
                }
            }
            findViewById<ImageView>(R.id.home_drawer_ic_exit).setOnClickListener {
                exit()
            }
        }
    }

    override fun getContentViewResId() = R.layout.fragment_home

    override fun onSubscribe() {
        viewModel.isRefreshing.observe(this) {
            binding.homeContent.homeMain.homeSrl.isRefreshing = it
        }
        viewModel.lists.observe(this) {
            adapter.submitList(it)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.homeNavDrawer.getHeaderView(0)
            .findViewById<ImageView>(R.id.home_drawer_ic_exit).visibility =
            if (token == null) View.GONE else View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        binding.homeDrawer.closeDrawer(Gravity.LEFT)
    }

    private fun exit() {
        MmkvUtils.clear()
        binding.homeNavDrawer.getHeaderView(0)
            .findViewById<ImageView>(R.id.home_drawer_ic_exit).visibility = View.GONE
        "登出成功".showToast()
    }
}