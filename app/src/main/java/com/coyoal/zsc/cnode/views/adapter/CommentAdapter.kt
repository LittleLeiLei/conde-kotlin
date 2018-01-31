package com.coyoal.zsc.cnode.views.adapter

import android.support.v7.widget.RecyclerView
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.entity.Comment
import com.coyoal.zsc.cnode.image.ImageLoaderWrapper
import com.coyoal.zsc.cnode.utils.TimeUtils
import com.zzhoujay.richtext.RichText
import kotlinx.android.synthetic.main.item_comment.view.*

/**
 *
 * Created by Administrator on 2018/1/13.
 */
class CommentAdapter: BaseRecyclerAdapter<Comment>() {
    override fun getItemLayout(): Int {
        return R.layout.item_comment
    }

    override fun bindView(holder: RecyclerView.ViewHolder?, bean: Comment, pos: Int) {
        holder!!.itemView.tv_comment_author.text = bean.author?.loginname
        holder.itemView.tv_comment_date.text = TimeUtils.isodate2String(bean.create_at)
        RichText.from(bean.content).into(holder.itemView.tv_comment_content)
        ImageLoaderWrapper.instance.load(holder.itemView.context, holder.itemView.iv_comment_avatar, bean.author?.avatar_url)
    }

}