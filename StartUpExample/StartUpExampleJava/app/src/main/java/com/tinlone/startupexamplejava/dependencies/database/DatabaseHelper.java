package com.tinlone.startupexamplejava.dependencies.database;

import com.tinlone.startupexamplejava.dependencies.Logger;

public class DatabaseHelper implements IDatabaseHelper {

    private static String config = null;

    private DatabaseHelper() {
        Logger.log("loglog", "DatabaseHelper initialized");
    }

    public static void init() {
        config = "init";
    }

    public static DatabaseHelper getInstance() {
        if (config == null){
            throw new IllegalStateException("config has no init");
        }
        return new DatabaseHelper();
    }

    @Override
    public boolean insert(Object obj) {
        return true;
    }
}
