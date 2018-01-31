package com.coyoal.zsc.cnode.contract

import com.coyoal.zsc.cnode.presenter.BasePresenter

/**
 *
 * Created by Administrator on 2018/1/13.
 */
class TopicCommentsContract {
    interface Model {
        fun thumbUp()
    }

    interface View {
        fun thumbUp()
    }

    abstract class Presenter<V>: BasePresenter<V>() {
        abstract fun thumbUp()
    }
}