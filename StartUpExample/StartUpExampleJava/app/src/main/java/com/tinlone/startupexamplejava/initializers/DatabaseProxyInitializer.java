package com.tinlone.startupexamplejava.initializers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import com.tinlone.startupexamplejava.dependencies.database.DatabaseHelper;
import com.tinlone.startupexamplejava.dependencies.database.DatabaseProxy;

import java.util.Arrays;
import java.util.List;

public class DatabaseProxyInitializer implements Initializer<DatabaseProxy> {
    @NonNull
    @Override
    public DatabaseProxy create(@NonNull Context context) {
        Log.i("loglog", "create: DatabaseProxyInitializer");
        DatabaseProxy.initialize(DatabaseHelper.getInstance());
        return DatabaseProxy.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Arrays.asList(LoggerInitializer.class, DatabaseHelperInitializer.class);
    }
}
