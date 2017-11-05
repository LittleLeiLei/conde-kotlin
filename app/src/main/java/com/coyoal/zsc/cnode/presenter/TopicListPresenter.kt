package com.coyoal.zsc.cnode.presenter

import com.coyoal.zsc.cnode.constract.TopicListConstract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.model.TopicListModel

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicListPresenter: BasePresenter<TopicListConstract.View>() {
    private val mModel = TopicListModel()

    fun loadTopics(tab: String, page: Int, limit: Int) {
//        mModel.getTopics(tab, page, limit, object: SimpleObserver<List<Topic>>() {
//            override fun onSuccess(data: List<Topic>) {
//                getView()?.setTopics(data)
//            }
//            override fun onFailure(errMsg: String) {
//            }
//        })
        val t: Topic = Topic()
        t.title = "测试文章"
        t.reply_count = 199
        getView()?.setTopics(arrayListOf(t))
    }
}