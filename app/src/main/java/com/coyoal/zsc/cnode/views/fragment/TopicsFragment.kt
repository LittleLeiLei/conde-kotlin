package com.coyoal.zsc.cnode.views.fragment

import android.view.View
import com.coyoal.zsc.cnode.constract.TopicListConstract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.presenter.TopicListPresenter
import com.coyoal.zsc.cnode.views.adapter.TopicAdapter
import com.coyoal.zsc.cnode.views.base.BaseListFragment

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicsFragment: BaseListFragment<Topic, TopicListConstract.View, TopicListPresenter>(), TopicListConstract.View {

    override fun initAdapter() {
        mAdapter = TopicAdapter()
    }

    override fun initData() {
        mPresenter?.loadTopics("share", 1, 10)
    }

    override fun initPresenter(): TopicListPresenter {
        return TopicListPresenter()
    }

    override fun onItemClick(view: View, data: Topic, position: Int) {
//        val intent = Intent(this, TopicDetailActivity::class.java)
//        val bundle = Bundle()
//        bundle.putString("topicId", data.id)
//        intent.putExtras(bundle)
//        startActivity(intent)
    }

    override fun setTopics(topics: List<Topic>) {
        mAdapter?.data = topics
    }
}