package com.viper.lib_net

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * created by viper on 2021/5/25
 * desc
 */
private const val BASE_URL = "http://120.78.180.59:8082"
var token: String? = null

val netModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                chain.request().let {
                    if (token != null) chain.proceed(
                        it.newBuilder().addHeader("token", token).build()
                    )
                    else chain.proceed(it)
                }
            }.build())
            .build()
    }
}