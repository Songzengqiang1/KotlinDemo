package com.lkl.demo.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import com.lkl.demo.R
import com.lkl.demo.adapter.PictureAdapter
import com.lkl.demo.base.BaseActivity
import com.lkl.demo.entity.PictureEntity
import com.lkl.demo.listener.PictureListener
import com.lkl.demo.presenter.PicturePresenterImpl
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : BaseActivity(), PictureListener {

    private var mList: MutableList<PictureEntity> = ArrayList()

    private lateinit var mAdapter: PictureAdapter

    private lateinit var presenterImpl: PicturePresenterImpl

    override fun preInitView() {
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_picture
    }

    override fun initView() {
        presenterImpl = PicturePresenterImpl(this)

//        Thread(Runnable {
//            val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null)
//            mList = presenterImpl.getPictures(cursor)
//            val msg = Message.obtain()
//            msg.arg1 = 1
//            handle.sendMessage(msg)
//        }).start()

        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null)
        mList = presenterImpl.getPictures(cursor)
        mAdapter = PictureAdapter(this, mList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter


//        async {
//            val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null)
//            var listItems = presenterImpl.getPictures(cursor)
//            uiThread {
//                recyclerView.adapter = PictureAdapter(this@BulbActivity, listItems)
//                recyclerView.layoutManager = LinearLayoutManager(this@BulbActivity)
//            }
//        }
    }

    override fun initEvent(savedInstanceState: Bundle?) {
    }

    override fun initViewListener() {
    }

    override fun getPictureFromBumb() {
    }

    val handle = object : Handler() {
        override fun handleMessage(msg: Message?) {
            when (msg?.arg1) {
                1 -> mAdapter.notifyDataSetChanged()
                else -> ""
            }
        }
    }
}