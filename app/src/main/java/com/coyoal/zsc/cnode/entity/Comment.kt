package com.coyoal.zsc.cnode.entity

import java.util.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class Comment {
    var id: String = ""
    var author: User? = null
    var content: String = ""
    var create_at: String = ""
    // private var reply_id: Any? = null
    var is_uped: Boolean = false
    var ups: List<String> = ArrayList<String>()
}