package com.coyoal.zsc.cnode.views.custom

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

/**
 *
 * Created by Administrator on 2018/1/15.
 */
class ExRecyclerView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : RecyclerView(context, attrs, defStyleAttr) {

    private var mAdapter: Adapter<RecyclerView.ViewHolder>? = null
    private var mHeaderView: View? = null
    private var mFooterView: View? = null

    constructor(context: Context?): this(context, null)

    constructor(context: Context?, attrs: AttributeSet?): this(context, attrs, 0)

    override fun setAdapter(adapter: Adapter<RecyclerView.ViewHolder>) {
        this.mAdapter = ExAdapter(adapter)
        super.setAdapter(mAdapter)
    }

    fun setHeaderView (header: View) {
        this.mHeaderView = header
        this.mAdapter!!.notifyItemInserted(0)
    }

    fun setFooterView (footer: View) {
        this.mFooterView = footer
        this.mAdapter!!.notifyItemInserted(this.mAdapter!!.itemCount)
    }

    inner class ExAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private val ITEM_HEADER = 0x111
        private val ITEM_FOOTER = 0x222
        private val ITEM_NORMAL = 0x333

        private var adapter: Adapter<RecyclerView.ViewHolder>? = null

        constructor(adapter: Adapter<RecyclerView.ViewHolder>?) {
            this.adapter = adapter
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            return when (viewType) {
                ITEM_HEADER -> object : RecyclerView.ViewHolder(this@ExRecyclerView.mHeaderView) {}
                ITEM_FOOTER -> object : RecyclerView.ViewHolder(this@ExRecyclerView.mFooterView) {}
                else -> this.adapter!!.createViewHolder(parent, viewType)
            }
        }

        override fun getItemCount(): Int {
            return adapter!!.itemCount + (if (mHeaderView == null) 0 else 1) + (if(mFooterView == null) 0 else 1)
        }

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            val type = getItemViewType(position)
            if (type in arrayOf(ITEM_HEADER, ITEM_FOOTER)) return
            val realPos = position - (if(mHeaderView == null) 0 else 1)
            this.adapter!!.onBindViewHolder(holder, realPos)
        }

        override fun getItemViewType(position: Int): Int {
            if (mHeaderView != null && position == 0) return ITEM_HEADER
            if (mFooterView != null && position == itemCount - 1) return ITEM_FOOTER
            return ITEM_NORMAL
        }
    }
}