package com.tinlone.startupexamplejava.dependencies;

import android.util.Log;

import java.util.HashMap;

/**
 * 模拟使用前必须初始化
 */
public class Logger {

    private static HashMap<String, Boolean> tagsShow = null;

    private Logger() {
        Logger.log("loglog", "Logger initialized");
    }

    public static void initialize() {
        // 仅做模拟
        tagsShow = new HashMap<>();
    }

    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    public static void log(String tag, String msg) {
        log(tag, msg, true);
    }

    private static boolean canShow(String tag, boolean show) {
        if (tagsShow == null) {
            throw new IllegalStateException("Logger has not initialize");
        }
        Boolean canShow = tagsShow.get(tag);
        return canShow != null ? canShow : show;
    }

    public static void log(String tag, String msg, boolean show) {
        if (canShow(tag, show)) {
            Log.i(tag, msg);
        }

    }

    private static final class Holder {
        public static final Logger INSTANCE = new Logger();
    }
}
