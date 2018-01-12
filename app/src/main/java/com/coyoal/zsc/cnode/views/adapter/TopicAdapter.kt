package com.coyoal.zsc.cnode.views.adapter

import android.support.v7.widget.RecyclerView
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.entity.Topic
import com.coyoal.zsc.cnode.utils.TimeUtils
import kotlinx.android.synthetic.main.item_topic.view.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicAdapter: BaseRecyclerAdapter<Topic>() {

    override fun getItemLayout(): Int {
        return R.layout.item_topic
    }

    override fun bindView(holder: RecyclerView.ViewHolder?, bean: Topic, pos: Int) {
        holder!!.itemView.tv_title.text = bean.title
        holder.itemView.tv_created_at.text = TimeUtils.isodate2String(bean.create_at)
        holder.itemView.tv_like_count.text = bean.reply_count.toString()
        holder.itemView.tv_author.text = bean.author?.loginname ?: "佚名"
    }
}