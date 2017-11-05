package com.coyoal.zsc.cnode.views.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.coyoal.zsc.cnode.R
import com.coyoal.zsc.cnode.views.adapter.MainPagerAdapter
import com.coyoal.zsc.cnode.views.custom.NavWidget
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
// @PermissionsRequestSync(permission = arrayOf(Manifest.permission.INTERNET), value = *intArrayOf(INTERNET_CODE))
class MainActivity: AppCompatActivity() {
    companion object {
        const val INTERNET_CODE: Int = 0x1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Permissions4M.get(this).requestSync()
        initViews()
    }

    private fun initViews() {
        vp_main.adapter = MainPagerAdapter(supportFragmentManager)
        tw_nav.addTab(NavWidget.Tab(this).icon(R.mipmap.ic_topic).name(R.string.tab_topic))
        tw_nav.addTab(NavWidget.Tab(this).icon(R.mipmap.ic_personal).name(R.string.tab_personal))
        tw_nav.setupWithViewPager(vp_main)
    }

//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        Permissions4M.onRequestPermissionsResult(this, requestCode, grantResults)
//    }
//
//    @PermissionsGranted(INTERNET_CODE)
//    fun permissionGranted(code: Int) {
//        when (code) {
//            INTERNET_CODE -> Toast.makeText(this, "网络权限授权成功", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    @PermissionsDenied(INTERNET_CODE)
//    fun permissionDenied(code: Int) {
//        when (code) {
//            INTERNET_CODE -> Toast.makeText(this, "网络权限授权失败", Toast.LENGTH_SHORT).show()
//        }
//    }
}