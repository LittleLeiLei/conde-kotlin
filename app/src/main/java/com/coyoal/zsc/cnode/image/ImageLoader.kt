package com.coyoal.zsc.cnode.image

import android.content.Context
import android.widget.ImageView

/**
 *
 * Created by chuxin on 2018/1/12.
 */
interface ImageLoader {

    fun load (context: Context, view: ImageView, url: String?)

    fun load (context: Context, view: ImageView, url: String?, width: Int, height: Int)
}