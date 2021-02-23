package com.tinlone.startupexamplejava.dependencies;

import com.tinlone.startupexamplejava.dependencies.database.DatabaseProxy;

public class Cache {

    static DatabaseProxy databaseProxy;

    private Cache() {
        Logger.log("loglog", "Cache initialized");
    }

    public static void initialize(DatabaseProxy db) {
        databaseProxy = db;
    }

    public static Cache getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        public static final Cache INSTANCE = new Cache();
    }

}
