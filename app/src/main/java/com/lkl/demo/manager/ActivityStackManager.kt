package com.lkl.demo.manager

import android.app.Activity
import java.util.*

class ActivityStackManager {
    var stackActivity: Stack<Activity> = Stack()

    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            ActivityStackManager()
        }

    }


    /**
     * @param activity
     * close activity
     */
    public fun popActivity(activity: Activity) {
        if (stackActivity.isEmpty()) return
        if (activity != null) {
            activity.finish()
            activity.overridePendingTransition(0, 0)
            stackActivity.remove(activity)
            // activity  = null       why activity is val
        }
    }

    /**
     * @param activity
     * add activity to stack
     */
    public fun pushActivity(activity: Activity) {
        stackActivity.add(activity)
    }

    /**
     * get current activity
     */
    public fun getCurrentActivity(): Activity {
        return stackActivity.lastElement()
    }

    /**
     *
     */
    public fun getFirstActivity(): Activity {
        return stackActivity.firstElement()
    }

    /**
     * remove all activity
     */
    public fun removeAllActivity() {
        stackActivity.removeAllElements()
    }

    /**
     * remove all activities but current activity
     */
    public fun removeAllActivityWithoutCurrent() {
        var activity: Activity = getCurrentActivity()
        while (true) {
            if (stackActivity.size == 1) {
                break
            }

            if (activity == getFirstActivity()) break else popActivity(getFirstActivity())
        }
    }


}