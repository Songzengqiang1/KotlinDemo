package com.lkl.demo.presenter

import android.database.Cursor
import android.provider.MediaStore
import com.lkl.demo.entity.PictureEntity
import com.lkl.demo.listener.PictureListener

class PicturePresenterImpl(private val listener: PictureListener) : Presenter {

//    private val mListener: PictureListener? = null
//
//    init {
//        mListener = listener
//    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isDead() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getPictureFromBumb(cursor: Cursor): MutableList<Map<String, String>> {
        var listItems: MutableList<Map<String, String>> = ArrayList()
        Thread(object : Runnable {
            override fun run() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                //        var nameList: ArrayList<String> = ArrayList()
//        var descList = ArrayList<String>()
//        var fileNames = ArrayList<String>()
                while (cursor.moveToNext()) {
                    //获取图片名称
                    val name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME))
                    //获取图片生成日期
                    val data: ByteArray = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
                    //获取图片详细信息
                    val description = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION))

//            nameList.add(name)
//            descList.add(description)
//            fileNames.add(String(data, 0, data.size - 1))
                    var hashMap = hashMapOf(description to String(data, 0, data.size - 1))
                    listItems.add(hashMap)

                }
                cursor.close()
            }

        }).start()
        return listItems
    }

    fun getPictures(cursor: Cursor): MutableList<PictureEntity> {
        var listItems: MutableList<PictureEntity> = ArrayList()
        while (cursor.moveToNext()) {
            //获取图片名称
            val name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME))
            //获取图片生成日期
            val data: ByteArray = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            //获取图片详细信息
            val description = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION))
            listItems.add(PictureEntity(name, "fhfhfhfh", String(data, 0, data.size - 1)))

        }
        cursor.close()
        return listItems
    }

}