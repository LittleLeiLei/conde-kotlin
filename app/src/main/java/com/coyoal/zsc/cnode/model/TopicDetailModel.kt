package com.coyoal.zsc.cnode.model

import com.coyoal.zsc.cnode.api.TopicApi
import com.coyoal.zsc.cnode.contract.TopicDetailContract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.http.RetrofitFactory
import com.coyoal.zsc.cnode.http.RxSchedulers
import com.coyoal.zsc.cnode.http.SimpleObserver

/**
 *
 * Created by Administrator on 2017/11/17.
 */
class TopicDetailModel: TopicDetailContract.Model{
    override fun getTopic(topicId: String, observer: SimpleObserver<Topic>) {
        val observable = RetrofitFactory.instance.create(TopicApi::class.java).getTopicDetail(topicId)
        observable.compose(RxSchedulers.compose()).subscribe(observer)
    }
}