package com.tinlone.startupexamplejava.initializers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import com.tinlone.startupexamplejava.dependencies.Cache;
import com.tinlone.startupexamplejava.dependencies.database.DatabaseProxy;

import java.util.Collections;
import java.util.List;

public class CacheInitializer implements Initializer<Cache> {
    @NonNull
    @Override
    public Cache create(@NonNull Context context) {
        Log.i("loglog", "create: CacheInitializer");
        Cache.initialize(DatabaseProxy.getInstance());
        return Cache.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(DatabaseProxyInitializer.class);
    }
}
