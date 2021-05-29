package com.viper.lib_net

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

/**
 * created by viper on 2021/5/29
 * desc
 */
@BindingAdapter("bindImg")
fun bindImg(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .error(R.drawable.ic_default_avatar)
        .apply { RequestOptions.bitmapTransform(CircleCrop()) }
        .into(view)
}