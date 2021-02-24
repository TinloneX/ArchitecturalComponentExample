package com.tinlone.lifecycleexamplejava;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class CameraLifecycleOwner implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.i("loglog", "ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(){
        Log.i("loglog", "ON_ANY");
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
        Log.i("loglog", "ON_DESTROY");
    }
}
