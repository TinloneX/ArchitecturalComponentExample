package com.tinlone.startupexamplejava.initializers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import com.tinlone.startupexamplejava.dependencies.database.DatabaseHelper;
import com.tinlone.startupexamplejava.dependencies.database.IDatabaseHelper;

import java.util.Collections;
import java.util.List;

public class DatabaseHelperInitializer implements Initializer<IDatabaseHelper> {
    @NonNull
    @Override
    public IDatabaseHelper create(@NonNull Context context) {
        Log.i("loglog", "create: DatabaseHelperInitializer");
        DatabaseHelper.init();
        return DatabaseHelper.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(LoggerInitializer.class);
    }
}
