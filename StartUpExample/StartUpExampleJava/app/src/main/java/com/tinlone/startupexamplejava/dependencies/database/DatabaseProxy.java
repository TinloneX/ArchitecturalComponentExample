package com.tinlone.startupexamplejava.dependencies.database;

import com.tinlone.startupexamplejava.dependencies.Logger;

/**
 * 假设使用代理模式做 插拔式DatabaseHelper
 */
public class DatabaseProxy {

    private static IDatabaseHelper dbHelper = null;

    private DatabaseProxy() {
        Logger.log("loglog", "DatabaseProxy initialized");
    }

    public static void initialize(IDatabaseHelper config) {
        // 仅做模拟
        dbHelper = config;
    }

    public static DatabaseProxy getInstance() {
        return Holder.INSTANCE;
    }

    public boolean insert(Object obj) {
        if (dbHelper == null) {
            throw new IllegalStateException("IDatabaseHelper has not initialize");
        }
        return dbHelper.insert(obj);
    }

    private static final class Holder {
        public static final DatabaseProxy INSTANCE = new DatabaseProxy();
    }

}
