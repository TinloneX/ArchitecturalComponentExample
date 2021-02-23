package com.tinlone.startupexamplekotlin.initializers

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.tinlone.startupexamplekotlin.dependencies.Logger

class LoggerInitializer : Initializer<Logger?> {
    override fun create(context: Context): Logger {
        Log.i("loglog", "create: LoggerInitializer")
        Logger.initialize()
        return Logger.getInstance()
    }

    override fun dependencies(): List<Class<out Initializer<*>?>> {
        // 预示没有其他依赖需要初始化
        return emptyList()
    }
}