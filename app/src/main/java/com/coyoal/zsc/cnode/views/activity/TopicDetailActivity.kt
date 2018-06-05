package com.coyoal.zsc.cnode.views.activity

import android.content.Intent
import android.os.Bundle
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.contract.TopicDetailContract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.image.ImageLoaderWrapper
import com.coyoal.zsc.cnode.presenter.TopicDetailPresenter
import com.coyoal.zsc.cnode.views.base.BaseActivity
import com.orhanobut.logger.Logger
import com.zzhoujay.richtext.RichText
import kotlinx.android.synthetic.main.activity_article_detail.*

/**
 *
 * Created by Administrator on 2017/11/17.
 */
class TopicDetailActivity : BaseActivity<TopicDetailContract.View, TopicDetailPresenter>(), TopicDetailContract.View {

    override fun getLayout(): Int {
        return R.layout.activity_article_detail
    }

    override fun initViews() {
        tv_read_count.text = "39"
        tv_share_count.text = "13"
        tv_comment_count.text = "128"
        tv_collect_count.text = "225"
    }

    override fun initData() {
        val topicId = intent.extras.getString("topicId")
        mPresenter.loadTopic(topicId)
    }

    override fun initEvents() {
        abl_bar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val alphaOfTitleCollapse = Math.abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange
            tv_toolbar_title.alpha = alphaOfTitleCollapse
            rl_info.alpha = 1.0f - alphaOfTitleCollapse
        }
        iv_toolbar_left.setOnClickListener { finish() }
        ll_comment.setOnClickListener {
            mPresenter.toComments()
        }
    }

    override fun initPresenter(): TopicDetailPresenter {
        return TopicDetailPresenter()
    }

    /**
     * 设置主题详情
     */
    override fun setTopic(topic: Topic) {
        tv_comment_author.text = topic.author?.loginname
        tv_title_expand.text = topic.title
        tv_toolbar_title.text = topic.title
        RichText.initCacheDir(this)
        RichText.from(topic.content).into(tv_topic_content)
        ImageLoaderWrapper.instance.load(this, iv_comment_avatar, topic.author?.avatar_url)
    }

    /**
     * 查看评论
     */
    override fun toComments(topic: Topic) {
        val intent = Intent(this, TopicCommentsActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("topic", topic)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}