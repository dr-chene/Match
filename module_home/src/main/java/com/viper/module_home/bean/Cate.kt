package com.viper.module_home.bean

import com.google.gson.annotations.SerializedName

/**
 * created by viper on 2021/5/31
 * desc
 */
data class Cate(
    @SerializedName("政策法规")
    val policies: List<String>,
    @SerializedName("信息资料")
    val news: List<String>,
    @SerializedName("技术标准")
    val techs: List<String>,
    @SerializedName("专家对接")
    val experts: List<String>
)
