package com.coyoal.zsc.cnode.views.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.coyoal.zsc.cnode.views.fragment.HomeFragment
import com.coyoal.zsc.cnode.views.fragment.PersonalFragment
import java.util.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class MainPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    private val fragments = ArrayList<Fragment>()

    init {
        fragments.add(HomeFragment())
        fragments.add(PersonalFragment())
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}