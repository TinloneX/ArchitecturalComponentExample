package com.tinlone.lifecycleexamplekotlin

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class CameraLifecycleObserver(lifecycle: Lifecycle) : LifecycleObserver {

    private var mLifecycle: Lifecycle = lifecycle

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        // 获取当前状态
        val currentState = mLifecycle.currentState
        // 至少已经执行onStart了
        val hasStarted = currentState.isAtLeast(Lifecycle.State.STARTED)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun initCamera() {
        Log.i("loglog", "ON_CREATE 初始化相机")
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
        Log.i("loglog", "ON_DESTROY 销毁资源")
    }
}