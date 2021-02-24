package com.tinlone.lifecycleexamplejava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new CameraLifecycleOwner());

        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                Log.i("loglog", "onActivityCreated");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                Log.i("loglog", "onActivityStarted");
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Log.i("loglog", "onActivityResumed");
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                Log.i("loglog", "onActivityPaused");
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
                Log.i("loglog", "onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                Log.i("loglog", "onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                Log.i("loglog", "onActivityDestroyed");
            }
        });
    }


}