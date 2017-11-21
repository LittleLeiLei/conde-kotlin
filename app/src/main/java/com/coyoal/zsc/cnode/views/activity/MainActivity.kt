package com.coyoal.zsc.cnode.views.activity

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.views.adapter.MainPagerAdapter
import com.coyoal.zsc.cnode.views.custom.NavWidget
import kotlinx.android.synthetic.main.activity_main.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.RuntimePermissions

/**
 *
 * Created by Administrator on 2017/11/5.
 */
@RuntimePermissions
class MainActivity: AppCompatActivity() {

    @NeedsPermission(Manifest.permission.INTERNET)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        vp_main.adapter = MainPagerAdapter(supportFragmentManager)
        tw_nav.addTab(NavWidget.Tab(this).icon(R.mipmap.ic_topic).name(R.string.tab_topic))
        tw_nav.addTab(NavWidget.Tab(this).icon(R.mipmap.ic_personal).name(R.string.tab_personal))
        tw_nav.setupWithViewPager(vp_main)
    }

    @OnPermissionDenied(Manifest.permission.INTERNET)
    fun permissionDenied() {
        Toast.makeText(this, "网络权限授权失败", Toast.LENGTH_SHORT).show()
    }
}