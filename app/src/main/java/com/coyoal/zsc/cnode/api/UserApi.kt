package com.coyoal.zsc.cnode.api

import com.coyoal.zsc.cnode.entity.BaseResponse
import com.coyoal.zsc.cnode.entity.User
import io.reactivex.Observable
import retrofit2.http.*

/**
 * 用户相关
 * Created by Administrator on 2017/11/5.
 */
interface UserApi {
    @GET("user/{userId}/detail")
    fun getUserDetail(@Path("userId") userId: String): Observable<BaseResponse<User>>

    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): Observable<BaseResponse<User>>
}