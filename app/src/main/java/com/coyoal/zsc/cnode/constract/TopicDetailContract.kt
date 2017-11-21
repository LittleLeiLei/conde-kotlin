package com.coyoal.zsc.cnode.constract

import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.http.SimpleObserver
import com.coyoal.zsc.cnode.presenter.BasePresenter

/**
 *
 * Created by Administrator on 2017/11/16.
 */
class TopicDetailContract {
    interface Model {
        fun getTopic(topicId: String, observer: SimpleObserver<Topic>)
    }

    interface View {
        fun setTopic(topic: Topic)
    }

    abstract class Presenter<V>: BasePresenter<V>() {
        abstract fun loadTopic(topicId: String)
    }
}