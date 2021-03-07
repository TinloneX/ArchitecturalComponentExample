package com.tinlone.viewmodelexamplejava;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ViewModelDemoLog";

    public int count = 0;

    public String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCounter = findViewById(R.id.button);
        EditText etInput = findViewById(R.id.editText);

        btnCounter.setText(String.format("UP COUNT (%s)", count));

        Log.i(TAG, "当前计数值：" + count);

        btnCounter.setOnClickListener(v -> {
            count++;
            btnCounter.setText(String.format("UP COUNT (%s)", count));
            Log.i(TAG, "计数增至：" + count);
        });

        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                input = s.toString();
                Log.i(TAG, "输入框输入：" + s);
            }
        });

        findViewById(R.id.button2).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SecActivity.class)));

    }

}