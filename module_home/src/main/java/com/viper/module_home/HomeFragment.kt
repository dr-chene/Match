package com.viper.module_home

import com.viper.lib_base.view.BaseFragment
import com.viper.module_home.adapter.HomeRecyclerViewAdapter
import com.viper.module_home.databinding.FragmentHomeBinding
import com.viper.module_home.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModel<HomeViewModel>()
    private val adapter by inject<HomeRecyclerViewAdapter> { parametersOf(viewModel) }

    override fun onInitView() {
        binding.homeRv.adapter = adapter
    }

    override fun onInitAction() {
//        binding.homeContent.homeAvatar.setOnClickListener {
//            binding.homeDrawer.openDrawer(Gravity.LEFT)
//        }
//        binding.homeNavDrawer.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.home_my_info -> {
//                    startActivity(Intent(this.context, InfoActivity::class.java))
//                    true
//                }
//                R.id.home_my_footprint -> {
//                    startActivity(Intent(this.context, FootprintActivity::class.java))
//                    true
//                }
//                R.id.home_my_wallet -> {
//                    "暂不支持该服务".showToast()
//                    true
//                }
//                R.id.home_my_service -> {
//                    startActivity(Intent(this.context, ServiceActivity::class.java))
//                    true
//                }
//                R.id.home_my_commitment -> {
//                    "暂不支持该服务".showToast()
//                    true
//                }
//                R.id.home_my_tools -> {
//                    "暂不支持该服务".showToast()
//                    true
//                }
//                else -> false
//            }
//        }
//        binding.homeContent.homeMain.homeSrl.setOnRefreshListener {
////            viewModel.refresh()
//        }
    }

    override fun getContentViewResId() = R.layout.fragment_home

    override fun onSubscribe() {
//        viewModel.isRefreshing.observe(this) {
//            binding.homeContent.homeMain.homeSrl.isRefreshing = it
//        }
        viewModel.lists.observe(this) {
            adapter.submitList(it)
        }
    }

//    private fun exit() {
//        MmkvUtils.clear()
//        binding.homeNavDrawer.getHeaderView(0)
//            .findViewById<ImageView>(R.id.home_drawer_ic_exit).visibility = View.GONE
//        "登出成功".showToast()
//    }
}