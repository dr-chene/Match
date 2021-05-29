package com.viper.match

import com.example.module_login.loginModule
import com.tencent.mmkv.MMKV
import com.viper.lib_base.BaseApp
import com.viper.lib_net.netModule
import com.viper.module_expert.expertModule
import com.viper.module_footprint.footprintModule
import com.viper.module_home.homeModule
import com.viper.module_info.infoModule
import com.viper.module_news.newsModule
import com.viper.module_policy.policyModule
import com.viper.module_service.serviceModule
import com.viper.module_tech.techModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * created by viper on 2021/5/23
 * desc
 */
class App: BaseApp() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@App)
            modules(appModule, netModule, homeModule, newsModule,
                policyModule, techModule, expertModule, serviceModule, footprintModule,
                infoModule, loginModule)
        }
    }
}