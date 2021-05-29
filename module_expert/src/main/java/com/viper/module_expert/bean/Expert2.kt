package com.viper.module_expert.bean

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.viper.lib_net.bean.Article
import java.lang.reflect.Type

/**
 * created by viper on 2021/5/29
 * desc
 */
data class Expert2(
    val name: String?,
    val identification: String?,
    val image: String?,
    val resume: String?,
    val blogs: List<Article>,
    val isArticle: Boolean = false
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        Gson().fromJson(parcel.readString(), listOf<Article>()::class.java),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(identification)
        parcel.writeString(image)
        parcel.writeString(resume)
        parcel.writeString(Gson().toJson(blogs))
        parcel.writeByte(if (isArticle) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Expert2> {
        override fun createFromParcel(parcel: Parcel): Expert2 {
            return Expert2(parcel)
        }

        override fun newArray(size: Int): Array<Expert2?> {
            return arrayOfNulls(size)
        }
    }
}

object Expert2DiffCallBack : DiffUtil.ItemCallback<Expert2>() {
    override fun areItemsTheSame(oldItem: Expert2, newItem: Expert2): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Expert2, newItem: Expert2): Boolean {
        return oldItem.resume == newItem.resume
    }
}