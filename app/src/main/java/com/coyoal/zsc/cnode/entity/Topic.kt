package com.coyoal.zsc.cnode.entity

import java.util.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class Topic {
    var id: String = ""
    var author_id: String = ""
    var tab: String = ""
    var content: String = ""
    var title: String = ""
    var last_reply_at: String = ""
    var good: Boolean = false
    var top: Boolean = false
    var is_collect: Boolean = false
    var reply_count: Int = 0
    var visit_count: Int = 0
    var create_at: String = ""
    var author: User? = null
    var replies: List<Comment> = ArrayList<Comment>()
}