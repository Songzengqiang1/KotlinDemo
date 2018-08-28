package com.lkl.demo.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lkl.demo.R
import com.lkl.demo.entity.PictureEntity

class PictureAdapter : RecyclerView.Adapter<PictureAdapter.MyHolder> {
    var mContext: Context? = null
    var dataList: MutableList<PictureEntity>? = null

    constructor(context: Context, list: MutableList<PictureEntity>) {
        mContext = context
        dataList = list
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.picture_item_view, p0, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList?.size as Int
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        val data = dataList!![p1]
        p0.picture.setImageBitmap(BitmapFactory.decodeFile(data.fileName))
        p0?.desc.text = data.name
    }

    class MyHolder : RecyclerView.ViewHolder {
        val picture: ImageView
        val desc: TextView

        constructor(view: View) : super(view) {
            picture  = view.findViewById(R.id.picture)
            desc = view.findViewById(R.id.text_view)
        }
    }

    interface PictureAdapterListener {
    }

}