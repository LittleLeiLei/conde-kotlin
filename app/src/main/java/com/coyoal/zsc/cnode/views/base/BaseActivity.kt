package com.coyoal.zsc.cnode.views.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.coyoal.zsc.cnode.presenter.BasePresenter

/**
 *
 * Created by Administrator on 2017/11/5.
 */
abstract class BaseActivity<V, T: BasePresenter<V>>: AppCompatActivity() {

    protected lateinit var mPresenter: T

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mPresenter = initPresenter()
        mPresenter.attach(this as V)

        initData()
        initViews()
        initEvents()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detach()
    }

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initData(): Unit

    abstract fun initViews(): Unit

    abstract fun initEvents(): Unit

    abstract fun initPresenter(): T
}