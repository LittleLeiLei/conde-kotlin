package com.coyoal.zsc.cnode.views.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.contract.TopicCommentsContract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.presenter.TopicCommentsPresenter
import com.coyoal.zsc.cnode.views.adapter.CommentAdapter
import com.coyoal.zsc.cnode.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_topic_comments.*
import kotlinx.android.synthetic.main.header_comments.view.*
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 *
 * Created by Administrator on 2018/1/13.
 */
class TopicCommentsActivity: BaseActivity<TopicCommentsContract.View, TopicCommentsContract.Presenter<TopicCommentsContract.View>>() {

    private lateinit var mAdapter: CommentAdapter
    private lateinit var mTopic: Topic

    override fun getLayout(): Int {
        return R.layout.activity_topic_comments
    }

    override fun initViews() {
        mAdapter = CommentAdapter()
        rv_comments.layoutManager = LinearLayoutManager(this)
        rv_comments.adapter = mAdapter
        mAdapter.data = mTopic.replies

        val mHeader: View = View.inflate(this, R.layout.header_comments, null)
        mHeader.tv_topic_author.text = mTopic.author.loginname
        mHeader.tv_topic_title.text = mTopic.title
        rv_comments.setHeaderView(mHeader)

        tv_toolbar_title.text = "评论"
        iv_toolbar_left.setBackgroundResource(R.mipmap.ic_arrow_back)
    }

    override fun initData() {
        mTopic = intent.extras.getParcelable("topic")
    }

    override fun initEvents() {
    }

    override fun initPresenter(): TopicCommentsContract.Presenter<TopicCommentsContract.View> {
        return TopicCommentsPresenter()
    }

}