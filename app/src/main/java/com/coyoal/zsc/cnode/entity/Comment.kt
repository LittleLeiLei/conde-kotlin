package com.coyoal.zsc.cnode.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
@JsonIgnoreProperties("is_uped")
class Comment {
    var id: String = ""
    var author: User? = null
    var content: String = ""
    var create_at: String = ""
    var reply_id: String? = ""
    // var is_uped: Boolean = false
    var ups: List<String> = ArrayList()
}