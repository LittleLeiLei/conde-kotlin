package com.coyoal.zsc.cnode.views.base

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.presenter.BasePresenter
import com.coyoal.zsc.cnode.views.adapter.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
abstract class BaseListFragment<T, V, P: BasePresenter<V>>: BaseFragment<V, P>(), BaseRecyclerAdapter.OnItemClickListener<T> {

    protected var mAdapter: BaseRecyclerAdapter<T>? = null

    override fun getLayout(): Int {
        return R.layout.fragment_list
    }

    override fun initViews(view: View?) {
        view!!.rv_data.layoutManager = LinearLayoutManager(activity)
        initAdapter()
        view!!.rv_data.adapter = mAdapter
    }

    override fun initEvents() {
        mAdapter?.setOnItemClickListener(this)
    }

    protected abstract fun initAdapter()
}