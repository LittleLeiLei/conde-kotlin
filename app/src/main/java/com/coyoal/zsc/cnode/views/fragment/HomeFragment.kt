package com.coyoal.zsc.cnode.views.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.views.adapter.TopicPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.include_toolbar.view.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class HomeFragment: Fragment() {
    private lateinit var mTopicPagerAdapter: TopicPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        initView(rootView)
        return rootView
    }

    private fun initView(view: View) {
        view.tv_title.text = "cnode"
        mTopicPagerAdapter = TopicPagerAdapter(childFragmentManager)
        view.vp_topics.adapter = mTopicPagerAdapter
        view.vp_topics.offscreenPageLimit = mTopicPagerAdapter.count - 1
        view.tl_category.setupWithViewPager(view.vp_topics)
    }
}