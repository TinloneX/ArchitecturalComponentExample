package com.tinlone.startupexamplejava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.tinlone.startupexamplejava.dependencies.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        throw new NullPointerException("error");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.log("tagtag","isFinishing : " +isFinishing());
    }
}