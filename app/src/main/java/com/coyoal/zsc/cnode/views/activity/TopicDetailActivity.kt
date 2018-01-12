package com.coyoal.zsc.cnode.views.activity

import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.constract.TopicDetailContract
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.image.ImageLoaderWrapper
import com.coyoal.zsc.cnode.presenter.TopicDetailPresenter
import com.coyoal.zsc.cnode.views.base.BaseActivity
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
        tv_read_count.text = "99"
        tv_share_count.text = "99"
        tv_comment_count.text = "99"
        tv_collect_count.text = "99"
    }

    override fun initData() {
        val topicId = intent.extras.getString("topicId")
        mPresenter?.loadTopic(topicId)
    }

    override fun initEvents() {
        abl_bar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val alphaOfTitleCollapse = (Math.abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange - 0.8) * 5
            tv_title.alpha = alphaOfTitleCollapse.toFloat()
        }
        iv_back.setOnClickListener { finish() }
    }

    override fun initPresenter(): TopicDetailPresenter? {
        return TopicDetailPresenter()
    }

    /**
     * 设置主题详情
     */
    override fun setTopic(topic: Topic) {
        tv_author.text = topic.author?.loginname
        tv_title_expand.text = topic.title
        tv_title.text = topic.title
        RichText.from(topic.content).into(tv_topic_content)
        ImageLoaderWrapper.instance.load(this, iv_avatar, topic.author?.avatar_url)
    }
}