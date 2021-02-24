package com.tinlone.startupexamplejava.initializers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import com.tinlone.startupexamplejava.dependencies.TXMap;

import java.util.Arrays;
import java.util.List;

public class MapInitializer implements Initializer<TXMap> {
    @NonNull
    @Override
    public TXMap create(@NonNull Context context) {
        Log.i("loglog", "create: MapInitializer");
        return new TXMap();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        // map依赖了log
        return Arrays.asList(LoggerInitializer.class, SomethingInitializer.class);
    }
}
