package com.tinlone.viewmodelexamplekotlin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var count = 0
    var input = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCounter = findViewById<Button>(R.id.button)
        val etInput = findViewById<EditText>(R.id.editText)
        btnCounter.text = String.format("UP COUNT (%s)", count)
        Log.i(TAG, "当前计数值：$count")
        btnCounter.setOnClickListener { v: View? ->
            count++
            btnCounter.text = String.format("UP COUNT (%s)", count)
            Log.i(TAG, "计数增至：$count")
        }
        etInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                input = s.toString()
                Log.i(TAG, "输入框输入：$s")
            }
        })
        findViewById<View>(R.id.button2).setOnClickListener { v: View? -> startActivity(Intent(this@MainActivity, SecActivity::class.java)) }
    }

    companion object {
        const val TAG = "ViewModelDemoLog"
    }
}