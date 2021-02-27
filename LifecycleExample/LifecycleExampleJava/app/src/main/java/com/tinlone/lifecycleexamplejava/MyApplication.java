package com.tinlone.lifecycleexamplejava;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

public class MyApplication extends Application {

    private ProcessLifecycleObserver observer;

    @Override
    public void onCreate() {
        super.onCreate();

        observer = new ProcessLifecycleObserver();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(observer);
    }

    public boolean isForeground() {
        return observer.isForeground();
    }
}
