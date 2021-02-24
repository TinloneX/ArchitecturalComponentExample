package com.tinlone.lifecycleexamplejava;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;


public class SecondActivity extends Activity implements LifecycleOwner {

    private LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("loglog", "======================== onCreate: SecondActivity");
        lifecycleRegistry = new LifecycleRegistry(this);
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        getLifecycle().addObserver(new CameraLifecycleObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }
}