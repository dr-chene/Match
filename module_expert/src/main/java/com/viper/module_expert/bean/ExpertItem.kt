package com.viper.module_expert.bean

//import androidx.recyclerview.widget.DiffUtil
//
///**
// * created by viper on 2021/5/26
// * desc
// */
//sealed class ExpertItem(
//    val area: String,
//    val field: String,
//    val name: String,
//    val cert: String,
//    val tag: String
//) {
//    class Expert(
//        area: String,
//        field: String,
//        name: String,
//        cert: String,
//        tag: String,
//        val expert: Int
//    ) : ExpertItem(area, field, name, cert, tag)
//
//    class Agency(
//        area: String,
//        field: String,
//        name: String,
//        cert: String,
//        tag: String,
//        val agency: Int
//    ) : ExpertItem(area, field, name, cert, tag)
//
//    object ExpertItemDiffCallback : DiffUtil.ItemCallback<ExpertItem>() {
//        override fun areItemsTheSame(oldItem: ExpertItem, newItem: ExpertItem): Boolean {
//            return oldItem.cert == newItem.cert
//        }
//
//        override fun areContentsTheSame(oldItem: ExpertItem, newItem: ExpertItem): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//}
