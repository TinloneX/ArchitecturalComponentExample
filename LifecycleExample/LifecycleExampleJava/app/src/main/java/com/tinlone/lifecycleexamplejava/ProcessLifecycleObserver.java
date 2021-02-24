package com.tinlone.lifecycleexamplejava;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ProcessLifecycleObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onForeground(){
        Log.i("loglog", "onForeground: ON_START");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onBackground(){
        Log.i("loglog", "onBackground: ON_STOP");
    }



}
