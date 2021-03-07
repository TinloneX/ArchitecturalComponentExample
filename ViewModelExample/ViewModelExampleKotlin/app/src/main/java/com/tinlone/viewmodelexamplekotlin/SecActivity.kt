package com.tinlone.viewmodelexamplekotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class SecActivity : AppCompatActivity() {
    private var viewModel: HomeDataViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)
        val btnCounter = findViewById<Button>(R.id.button)

//        viewModel = new ViewModelProvider(this).get(HomeDataViewModel.class);
        viewModel = ViewModelProvider(
            this, MyViewModelFactory("i have default config")
        )[HomeDataViewModel::class.java]

        Log.i(TAG, "读取viewModel.hashCode(): " + viewModel.hashCode())
        Log.i(TAG, "读取config：" + viewModel!!.readConfig())

        btnCounter.text = String.format("UP COUNT (%s)", viewModel!!.count)
        Log.i(TAG, "当前计数值：" + viewModel!!.count)
        btnCounter.setOnClickListener {
            viewModel!!.count++
            btnCounter.text = String.format("UP COUNT (%s)", viewModel!!.count)
            Log.i(TAG, "计数增至：" + viewModel!!.count)
        }
    }

    companion object {
        const val TAG = "ViewModelDemoLog"
    }
}