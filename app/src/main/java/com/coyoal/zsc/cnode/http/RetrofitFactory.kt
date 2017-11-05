package com.coyoal.zsc.cnode.http

import com.coyoal.zsc.cnode.utils.NetworkUtils
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *
 * Created by Administrator on 2017/11/4.
 */
class RetrofitFactory private constructor(): Interceptor {

    private var mRetrofit: Retrofit
    private var mClient: OkHttpClient
    private val TIMEOUT: Long = 30
    private val baseUrl = "https://cnodejs.org/api/v1/"

    private object SingletonHolder { val INSTANCE = RetrofitFactory() }

    // 伴生对象和延迟加载实现单例
    companion object {
        val instance: RetrofitFactory by lazy { SingletonHolder.INSTANCE }
    }

    init {
        mClient = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .cache(Cache(File(""), 14 * 1024 * 100))
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(this)
                .build()

        mRetrofit = Retrofit.Builder()
                .client(mClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
    }

    fun <T> create(clazz: Class<T>): T = mRetrofit.create(clazz)

    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain!!.request()
        if (!NetworkUtils.isAvailable()) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
        }
        val response = chain.proceed(request)
        return if (NetworkUtils.isAvailable()) {
            val cacheControl: String = request.cacheControl().toString()
            response.newBuilder().header("Cache-Control", cacheControl)
                    .removeHeader("Pragma").build()
        } else {
            response.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=${7 * 24 * 60 * 60}")
                    .removeHeader("Pragma").build()
        }
    }
}