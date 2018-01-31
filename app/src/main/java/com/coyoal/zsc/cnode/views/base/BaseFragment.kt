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

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getLayout(), container, false)
        mPresenter = initPresenter()
        mPresenter.attach(this as V)
        initViews(rootView)
        initData()
        initEvents()
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.detach()
    }

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initViews(view: View?)

    abstract fun initData()

    abstract fun initEvents()

    abstract fun initPresenter(): T
}