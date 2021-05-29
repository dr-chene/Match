package com.viper.module_expert.adapter

//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.viper.module_expert.bean.ExpertItem
//import com.viper.module_expert.databinding.RecycleItemAgencyBinding
//import com.viper.module_expert.databinding.RecycleItemExpertBinding

/**
 * created by viper on 2021/5/26
 * desc
 */
//class ExpertRecyclerViewAdapter :
//    ListAdapter<ExpertItem, RecyclerView.ViewHolder>(ExpertItem.ExpertItemDiffCallback) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            0 -> ExpertViewHolder(
//                RecycleItemExpertBinding.inflate(
//                    LayoutInflater.from(parent.context), parent, false
//                )
//            )
//
//            else -> AgencyViewHolder(
//                RecycleItemAgencyBinding.inflate(
//                    LayoutInflater.from(parent.context), parent, false
//                )
//            )
//
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (val item = getItem(position)) {
//            is ExpertItem.Expert -> {
//                (holder as ExpertViewHolder).bind(item)
//            }
//            is ExpertItem.Agency -> {
//                (holder as AgencyViewHolder).bind(item)
//            }
//        }
//    }
//
//    override fun getItemViewType(position: Int) =
//        when (getItem(position)) {
//            is ExpertItem.Expert -> 0
//            is ExpertItem.Agency -> 1
//        }
//
//    class ExpertViewHolder(
//        private val binding: RecycleItemExpertBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(expert: ExpertItem.Expert) {
//            binding.expert = expert
//            binding.executePendingBindings()
//        }
//    }
//
//    class AgencyViewHolder(
//        private val binding: RecycleItemAgencyBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(agency: ExpertItem.Agency) {
//            binding.agency = agency
//            binding.executePendingBindings()
//        }
//    }
//}