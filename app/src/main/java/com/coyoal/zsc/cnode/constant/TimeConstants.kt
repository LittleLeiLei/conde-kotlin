package com.coyoal.zsc.cnode.constant

import android.support.annotation.IntDef

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TimeConstants {
    companion object {
        /**
         * 毫秒与毫秒的倍数
         */
        const val MSEC: Long = 1
        /**
         * 秒与毫秒的倍数
         */
        const val SEC: Long = 1000
        /**
         * 分与毫秒的倍数
         */
        const val MIN: Long = 60000
        /**
         * 时与毫秒的倍数
         */
        const val HOUR: Long = 3600000
        /**
         * 天与毫秒的倍数
         */
        const val DAY: Long = 86400000
    }

    @IntDef(MSEC, SEC, MIN, HOUR, DAY)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class Unit
}