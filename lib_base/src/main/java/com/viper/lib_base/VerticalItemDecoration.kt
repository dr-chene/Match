package com.viper.lib_base

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * created by viper on 2021/5/29
 * desc
 */
class VerticalItemDecoration(
    private val space: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val totalCount = parent.adapter?.itemCount ?: return
        if (position == totalCount - 1) {
            outRect.bottom = space
        } else {
            outRect.bottom = 0
        }
        outRect.top = space
    }
}

fun dip2px(value: Float, context: Context): Int {
    val scale = context.resources.displayMetrics.density
    return (value * scale + 0.5).toInt()
}