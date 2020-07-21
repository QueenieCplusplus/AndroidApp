package com.katesapp2019.android.kslitesportyapp.Base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.jeremyliao.liveeventbus.LiveEventBus

class BaseApp: Application() {

    companion object {
        lateinit var instance: BaseApp
    }

    fun setAppContext(): BaseApp {
        return instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this //todo Live Event Bus
        LiveEventBus.get()
            .Config()
            .supportBroadcast(this)
            .lifecycleObserverAlwaysActive(true)
        registerActivityLifecycleCallbacks()
    }

    private fun registerActivityLifecycleCallbacks() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
                //todo import java.lang.ref.WeakReference
            }

            override fun onActivityResumed(activity: Activity?) {

            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {

            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            }

        })
    }

}