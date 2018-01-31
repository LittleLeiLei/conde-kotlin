package com.coyoal.zsc.cnode.views.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.coyoal.zsc.cnode.contract.TopicListContract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.presenter.TopicListPresenter
import com.coyoal.zsc.cnode.views.activity.TopicDetailActivity
import com.coyoal.zsc.cnode.views.adapter.TopicAdapter
import com.coyoal.zsc.cnode.views.base.BaseListFragment

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicsFragment: BaseListFragment<Topic, TopicListContract.View, TopicListPresenter>(), TopicListContract.View {

    override fun initAdapter() {
        mAdapter = TopicAdapter()
    }

    override fun initData() {
        val tab = arguments?.getString("tab_key") as String
        mPresenter.loadTopics(tab, 1, 10)
    }

    override fun initPresenter(): TopicListPresenter {
        return TopicListPresenter()
    }

    override fun onItemClick(view: View, bean: Topic, pos: Int) {
        val intent = Intent(this.context, TopicDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putString("topicId", bean.id)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun setTopics(topics: List<Topic>) {
        mAdapter.data = topics
    }
}