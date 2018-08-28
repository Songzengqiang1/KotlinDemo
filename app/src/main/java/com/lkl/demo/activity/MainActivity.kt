package com.lkl.demo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.lkl.demo.R
import com.lkl.demo.base.BaseActivity
import com.lkl.demo.bean.UserInfoVo
import com.lkl.demo.https.HttpUtil
import com.lkl.demo.https.ProgressSubscriber

class MainActivity : BaseActivity() {

    private var mTranslationBtn: Button? = null
    private var mAlBumBtn: Button? = null

    override fun preInitView() {

    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main_layout
    }

    override fun initView() {
        mTranslationBtn = findViewById(R.id.btn1)
        mAlBumBtn = findViewById(R.id.btn2)
    }

    override fun initEvent(savedInstanceState: Bundle?) {

    }

    override fun initViewListener() {
        mTranslationBtn?.setOnClickListener {
           val intent1 : Intent = Intent(this, TranslationActivity::class.java)
            startActivity(intent1)
        }
        mAlBumBtn?.setOnClickListener {
            val intent2 : Intent = Intent(this, PictureActivity::class.java)
            startActivity(intent2)
        }
    }

    //带进度框的网络请求
    private fun requestNetwork() {

        val progressSubscriber = object : ProgressSubscriber<UserInfoVo>(this@MainActivity, "请求中...") {

            override fun _onNext(retData: UserInfoVo?) {
                Toast.makeText(this@MainActivity, "请求成功!!!", Toast.LENGTH_SHORT).show()
            }

            override fun _onError(errorCode: Int, msg: String) {
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
        }
        HttpUtil.instance.userLogin("lisi", "123456", this, progressSubscriber)
    }
}
