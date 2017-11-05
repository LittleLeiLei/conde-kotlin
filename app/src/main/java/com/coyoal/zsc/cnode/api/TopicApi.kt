package com.coyoal.zsc.cnode.api

import com.coyoal.zsc.cnode.entity.BaseResponse
import com.coyoal.zsc.cnode.entity.Topic
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 *
 * Created by Administrator on 2017/11/5.
 */
interface TopicApi {
    @GET("topics")
    fun getArticleList(@QueryMap params: Map<String, String>): Observable<BaseResponse<List<Topic>>>

    @GET("topic/{id}")
    fun getTopicDetail(@Path("id") topicId: String): Observable<BaseResponse<Topic>>
}