package com.coyoal.zsc.cnode.views.adapter

import android.support.annotation.LayoutRes
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *
 * Created by Administrator on 2017/11/5.
 */
abstract class BaseRecyclerAdapter<T>: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<T> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private lateinit var mListener: OnItemClickListener<T>

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        bindView(holder, data[position], position)
        holder!!.itemView.setOnClickListener {
            view -> mListener.onItemClick(view, data[position], position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(getItemLayout(), parent, false)
        return object: RecyclerView.ViewHolder(view) {}
    }

    @LayoutRes
    protected abstract fun getItemLayout(): Int

    /**
     * 初始化Holder
     */
    // protected abstract fun initHolder(child: View): RecyclerView.ViewHolder

    /**
     * 绑定视图
     */
    protected abstract fun bindView(holder: RecyclerView.ViewHolder?, bean: T, pos: Int)

    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        mListener = listener
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(view: View, bean: T, pos: Int)
    }
}