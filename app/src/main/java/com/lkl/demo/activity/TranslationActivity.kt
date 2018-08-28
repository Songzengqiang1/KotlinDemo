package com.lkl.demo.activity

import android.os.Bundle
import android.view.View
import com.lkl.demo.R
import com.lkl.demo.base.BaseActivity

class TranslationActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        val id = p0?.id
        when (id) {
            R.id.lan_from -> {

            }
            R.id.lan_to -> {

            }

            R.id.edit_content -> {

            }

            R.id.to_content -> {

            }

            R.id.translation -> {
                translation()
            }
        }
    }

    override fun preInitView() {
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_translation
    }


    override fun initView() {

    }

    override fun initEvent(savedInstanceState: Bundle?) {
    }

    override fun initViewListener() {
    }

    fun translation() {

    }
}