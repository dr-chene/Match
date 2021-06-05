package com.viper.module_service

import com.viper.lib_base.view.BaseFragment
import com.viper.module_service.adapter.Service4RecyclerViewAdapter
import com.viper.module_service.bean.ServiceItem
import com.viper.module_service.databinding.FragmentServiceBinding
import org.koin.android.ext.android.inject

class ServiceFragment : BaseFragment<FragmentServiceBinding>() {
    private val adapter by inject<Service4RecyclerViewAdapter>()
    private val lists by lazy {
        arrayListOf(
            ServiceItem("知识产权咨询"),
            ServiceItem("知识产权评估"),
            ServiceItem("知识产权代理"),
            ServiceItem("知识产权司法鉴定"),
            ServiceItem("技术需求"),
            ServiceItem("技术评估"),
            ServiceItem("技术咨询"),
            ServiceItem("技术转移"),
            ServiceItem("技术研讨会"),
            ServiceItem("商务谈判")
        )
    }

    override fun onInitView() {
        binding.serviceRv.adapter = adapter
        adapter.submitList(lists)
    }

    override fun onInitAction() {

    }

    override fun getContentViewResId() = R.layout.fragment_service

}