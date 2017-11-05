package com.coyoal.zsc.cnode.entity

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class BaseResponse<T> {
    var code: Int = 0
    var message: String = ""
    var data: T? = null
    var isSuccess: Boolean = false
}