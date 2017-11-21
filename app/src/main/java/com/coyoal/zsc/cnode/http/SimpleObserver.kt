package com.coyoal.zsc.cnode.http

import com.coyoal.zsc.cnode.entity.BaseResponse
import com.orhanobut.logger.Logger
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *
 * Created by Administrator on 2017/11/5.
 */
abstract class SimpleObserver<T> : Observer<BaseResponse<T>> {
    override fun onSubscribe(d: Disposable) {
    }

    override fun onError(e: Throwable) {
        onFailure(e.message ?: "request  failed")
    }

    override fun onComplete() {
    }

    @Suppress("UNCHECKED_CAST")
    override fun onNext(t: BaseResponse<T>) {
        if (t.isSuccess) {
            onSuccess(t.data as T)
        } else {
            Logger.e(t.message)
            onFailure(t.message)
        }
    }

    abstract fun onSuccess(data: T)

    abstract fun onFailure(errMsg: String)
}