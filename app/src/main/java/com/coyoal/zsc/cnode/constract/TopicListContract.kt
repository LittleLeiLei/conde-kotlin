package com.coyoal.zsc.cnode.constract

import android.support.annotation.NonNull
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.http.SimpleObserver
import com.coyoal.zsc.cnode.presenter.BasePresenter

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicListContract {
    interface View {
        fun setTopics(topics: List<Topic>)
    }

    interface Model {
        fun getTopics(@NonNull tab: String, @NonNull page: Int, @NonNull limit: Int, observer: SimpleObserver<List<Topic>>)
    }

    abstract class Presenter<V>: BasePresenter<V>() {
        abstract fun loadTopics(@NonNull tab: String, @NonNull page: Int, @NonNull offset: Int)
    }
}