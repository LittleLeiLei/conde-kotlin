package com.coyoal.zsc.cnode.model

import com.coyoal.zsc.cnode.api.TopicApi
import com.coyoal.zsc.cnode.constract.TopicListConstract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.http.RetrofitFactory
import com.coyoal.zsc.cnode.http.RxSchedulers
import com.coyoal.zsc.cnode.http.SimpleObserver

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicListModel : TopicListConstract.Model {

    override fun getTopics(tab: String, limit: Int, page: Int, observer: SimpleObserver<List<Topic>>) {
        val params = mapOf<String, String>(
                "tab" to tab,
                "page" to page.toString(),
                "limit" to limit.toString()
        )
        val observable = RetrofitFactory.instance.create(TopicApi::class.java).getArticleList(params)
        observable.compose(RxSchedulers.compose()).subscribe(observer)
    }
}