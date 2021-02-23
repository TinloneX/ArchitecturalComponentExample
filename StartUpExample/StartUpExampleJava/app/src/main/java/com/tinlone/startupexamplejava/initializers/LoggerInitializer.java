package com.tinlone.startupexamplejava.initializers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import com.tinlone.startupexamplejava.dependencies.Logger;

import java.util.Collections;
import java.util.List;

public class LoggerInitializer implements Initializer<Logger> {


    @NonNull
    @Override
    public Logger create(@NonNull Context context) {
        Log.i("loglog", "create: LoggerInitializer");
        Logger.initialize();
        return Logger.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        // 预示没有其他依赖需要初始化
        return Collections.emptyList();
    }
}
