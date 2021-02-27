package com.tinlone.lifecycleexamplejava;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new CameraLifecycleObserver(getLifecycle()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
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


    public void gotoSecondActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }


    public boolean inAppOnForeground(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
            String packageName = context.getPackageName();
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
                if (appProcesses == null) {
                    return false;
                }
                for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                    if (packageName.equals(appProcess.processName)
                            && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}