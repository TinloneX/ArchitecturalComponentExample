package com.tinlone.lifecycleexamplekotlin

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class MyApplication() : Application() {

    private var observer: ProcessLifecycleObserver? = null

    override fun onCreate() {
        super.onCreate()
        observer = ProcessLifecycleObserver()
        ProcessLifecycleOwner.get().lifecycle.addObserver(observer!!)
    }

    fun isForeground(): Boolean {
        return observer!!.isForeground()
    }
}