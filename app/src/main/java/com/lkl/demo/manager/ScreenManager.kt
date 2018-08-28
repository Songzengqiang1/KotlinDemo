package com.lkl.demo.manager

import android.content.pm.ActivityInfo
import android.os.Build
import android.view.Window
import android.view.WindowManager
import com.lkl.demo.base.BaseActivity

class ScreenManager {

    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            ScreenManager()
        }

    }


    public fun setFullScreen(isChange: Boolean, activity: BaseActivity) {
        if (!isChange) return
        activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

    }

    public fun setStatusBar(isChange: Boolean, activity: BaseActivity) {
        if (!isChange) return
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //透明导航栏
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

        }

    }

    public fun setScreenRoate(isChange: Boolean, activity: BaseActivity) {
        if (!isChange) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

}