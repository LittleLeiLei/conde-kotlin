package com.coyoal.zsc.cnode.views.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coyoal.zsc.cnode.presenter.BasePresenter

/**
 *
 * Created by Administrator on 2017/11/5.
 */
abstract class BaseFragment<V, T: BasePresenter<V>>: Fragment() {
    protected lateinit var mPresenter: T
    private var rootView: View? = null

    private var isUIPrepared = false
    private var isInited = false

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getLayout(), container, false)
        isUIPrepared = true
        mPresenter = initPresenter()
        mPresenter.attach(this as V)
        initViews(rootView)
        initEvents()
        lazyLoad()
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.detach()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoad()
        }
    }

    // 懒加载
    private fun lazyLoad() {
        // setUserVisibleHint()会在onCreateView()之前调用一次，isUIPrepared防止此时加载数据
        // isInited加载过数据后无需重复加载
        if (userVisibleHint && isUIPrepared && !isInited) {
            initData()
            isInited = true
        }
    }

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initViews(view: View?)

    abstract fun initData()

    abstract fun initEvents()

    abstract fun initPresenter(): T
}