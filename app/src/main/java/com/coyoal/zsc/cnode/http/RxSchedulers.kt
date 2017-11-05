package com.coyoal.zsc.cnode.http

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class RxSchedulers {
    companion object {
        fun <T> compose(): ObservableTransformer<T, T> {
            return ObservableTransformer {
                it.subscribeOn(Schedulers.io())
                        .doOnSubscribe {  }
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }
}