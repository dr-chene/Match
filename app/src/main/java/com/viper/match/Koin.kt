package com.viper.match

import org.koin.dsl.module

/**
 * created by viper on 2021/5/23
 * desc
 */
val appModule = module {
    single { AppDataBase.buildDatabase(get()) }
}