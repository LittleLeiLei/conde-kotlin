package com.coyoal.zsc.cnode.app

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class App: Application() {

    companion object Factory {
        private var app: Application? = null
        fun get(): Application? = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        initial()
    }

    private fun initial() {
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}