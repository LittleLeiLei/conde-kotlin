package com.coyoal.zsc.cnode.model

import com.coyoal.zsc.cnode.api.TopicApi
import com.coyoal.zsc.cnode.constract.TopicListContract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.http.RetrofitFactory
import com.coyoal.zsc.cnode.http.RxSchedulers
import com.coyoal.zsc.cnode.http.SimpleObserver

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicListModel : TopicListContract.Model {

    override fun getTopics(tab: String, page: Int, limit: Int, observer: SimpleObserver<List<Topic>>) {
        val params = mapOf<String, String>(
                "tab" to tab,
                "page" to page.toString(),
                "limit" to limit.toString()
        )
        val observable = RetrofitFactory.instance.create(TopicApi::class.java).getArticleList(params)
        observable.compose(RxSchedulers.compose()).subscribe(observer)
    }
}