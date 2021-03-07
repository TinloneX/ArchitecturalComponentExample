package com.tinlone.viewmodelexamplejava;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class SecActivity extends AppCompatActivity {

    public static final String TAG = "ViewModelDemoLog";

    private HomeDataViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        Button btnCounter = findViewById(R.id.button);

//        viewModel = new ViewModelProvider(this).get(HomeDataViewModel.class);
        viewModel = new ViewModelProvider(this, new MyViewModelFactory("i have default config"))
                .get(HomeDataViewModel.class);

        Log.i(TAG, "读取viewModel.hashCode(): " + viewModel.hashCode());
        Log.i(TAG, "读取config：" + viewModel.readConfig());

        btnCounter.setText(String.format("UP COUNT (%s)", viewModel.count));

        Log.i(TAG,"当前计数值：" + viewModel.count);

        btnCounter.setOnClickListener(v -> {
            viewModel.count++;
            btnCounter.setText(String.format("UP COUNT (%s)", viewModel.count));
            Log.i(TAG,"计数增至：" + viewModel.count);
        });

    }
}