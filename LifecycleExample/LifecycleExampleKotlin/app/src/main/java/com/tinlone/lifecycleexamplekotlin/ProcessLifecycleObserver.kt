package com.tinlone.lifecycleexamplekotlin

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ProcessLifecycleObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Log.i("loglog", "onForeground: ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Log.i("loglog", "onBackground: ON_STOP")
    }
}