package com.coyoal.zsc.cnode.image

import android.content.Context
import android.widget.ImageView

/**
 *
 * Created by chuxin on 2018/1/12.
 */
class ImageLoaderWrapper private constructor () : ImageLoader {

    private var mCore: ImageLoader = GlideCore()

    private object SingletonHolder { val INSTANCE = ImageLoaderWrapper() }

    companion object {
        val instance: ImageLoaderWrapper by lazy { SingletonHolder.INSTANCE }
    }

    override fun load(context: Context, view: ImageView, url: String?) {
        mCore.load(context, view, url)
    }

    override fun load(context: Context, view: ImageView, url: String?, width: Int, height: Int) {
        mCore.load(context, view, url, width, height)
    }
}