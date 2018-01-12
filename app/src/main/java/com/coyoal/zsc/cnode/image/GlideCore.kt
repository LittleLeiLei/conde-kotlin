package com.coyoal.zsc.cnode.image

import android.content.Context
import android.widget.ImageView
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.app.GlideApp

/**
 *
 * Created by chuxin on 2018/1/12.
 */
class GlideCore : ImageLoader {

    override fun load(context: Context, view: ImageView, url: String?) {
        GlideApp.with(view).load(url).centerCrop().placeholder(R.mipmap.ic_default_avatar).into(view)
    }

    override fun load(context: Context, view: ImageView, url: String?, width: Int, height: Int) {
        GlideApp.with(view).load(url).centerCrop().placeholder(R.mipmap.ic_default_avatar).into(view)
    }
}