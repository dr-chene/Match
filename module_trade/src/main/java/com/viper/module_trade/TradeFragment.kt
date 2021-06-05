package com.viper.module_trade

import com.viper.lib_base.view.BaseFragment
import com.viper.lib_net.showToast
import com.viper.module_trade.databinding.FragmentTradeBinding

class TradeFragment : BaseFragment<FragmentTradeBinding>() {

    override fun onInitView() {

    }

    override fun onInitAction() {
        binding.tradeSearchButton.setOnClickListener {
            "功能暂未实现".showToast()
        }
        binding.tradeCard.tradeAddInfo.setOnClickListener {
            "功能暂未实现".showToast()
        }
    }

    override fun getContentViewResId() = R.layout.fragment_trade

}