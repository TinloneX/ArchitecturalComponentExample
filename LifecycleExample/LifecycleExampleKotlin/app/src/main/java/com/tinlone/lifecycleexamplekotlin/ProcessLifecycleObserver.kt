package com.tinlone.lifecycleexamplekotlin

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ProcessLifecycleObserver : LifecycleObserver {
    private var isForeground = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Log.i("loglog", "onForeground: ON_START")
        isForeground = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Log.i("loglog", "onBackground: ON_STOP")
        isForeground = false
    }

    fun isForeground(): Boolean {
        return isForeground
    }
}