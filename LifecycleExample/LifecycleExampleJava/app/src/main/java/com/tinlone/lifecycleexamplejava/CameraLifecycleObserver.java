package com.tinlone.lifecycleexamplejava;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class CameraLifecycleObserver implements LifecycleObserver {

    private Lifecycle mLifecycle = null;

    public CameraLifecycleObserver(Lifecycle lifecycle){
        mLifecycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(){
        // 获取当前状态
        Lifecycle.State currentState = mLifecycle.getCurrentState();
        // 至少已经执行onStart了
        boolean hasStarted = currentState.isAtLeast(Lifecycle.State.STARTED);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void initCamera(){
        Log.i("loglog", "ON_CREATE 初始化相机");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void openCamera() {
        Log.i("loglog", "ON_RESUME 打开相机");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void closeCamera() {
        Log.i("loglog", "ON_PAUSE 关闭相机");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        Log.i("loglog", "ON_DESTROY 销毁资源");
    }
}
