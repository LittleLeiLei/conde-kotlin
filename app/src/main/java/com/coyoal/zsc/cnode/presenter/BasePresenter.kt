package com.coyoal.zsc.cnode.presenter

import android.support.annotation.Nullable
import java.lang.ref.WeakReference

/**
 *
 * Created by Administrator on 2017/11/5.
 */
abstract class BasePresenter<T> {
    private var mView: WeakReference<T>? = null

    fun attach(view: T) {
        mView = WeakReference(view)
    }

    fun detach() {
        if (mView?.get() !== null) {
            mView?.clear()
        }
        mView = null
    }

    @Nullable
    protected fun getView() = mView?.get()
}