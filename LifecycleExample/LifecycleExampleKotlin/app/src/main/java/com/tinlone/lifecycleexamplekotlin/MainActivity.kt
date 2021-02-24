package com.tinlone.lifecycleexamplekotlin

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(CameraLifecycleObserver())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                    Log.i("loglog", "onActivityCreated")
                }

                override fun onActivityStarted(activity: Activity) {
                    Log.i("loglog", "onActivityStarted")
                }

                override fun onActivityResumed(activity: Activity) {
                    Log.i("loglog", "onActivityResumed")
                }

                override fun onActivityPaused(activity: Activity) {
                    Log.i("loglog", "onActivityPaused")
                }

                override fun onActivityStopped(activity: Activity) {
                    Log.i("loglog", "onActivityStopped")
                }

                override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
                    Log.i("loglog", "onActivitySaveInstanceState")
                }

                override fun onActivityDestroyed(activity: Activity) {
                    Log.i("loglog", "onActivityDestroyed")
                }
            })
        }
    }

    fun gotoSecondActivity(view: View?) {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}