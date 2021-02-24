package com.tinlone.lifecycleexamplekotlin

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class CameraLifecycleObserver : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i("loglog", "ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.i("loglog", "ON_ANY")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun openCamera() {
        Log.i("loglog", "ON_RESUME 打开相机")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun closeCamera() {
        Log.i("loglog", "ON_PAUSE 关闭相机")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i("loglog", "ON_DESTROY")
    }
}