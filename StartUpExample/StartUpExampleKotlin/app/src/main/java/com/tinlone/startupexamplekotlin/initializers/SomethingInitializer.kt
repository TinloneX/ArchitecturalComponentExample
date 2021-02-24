package com.tinlone.startupexamplekotlin.initializers

import android.content.Context
import androidx.startup.Initializer
import com.tinlone.startupexamplekotlin.dependencies.Logger

class SomethingInitializer: Initializer<Unit> {
    override fun create(context: Context): Unit {
        Logger.log("loglog","do something init")
        Logger.log("loglog", "create: SomethingInitializer")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(LoggerInitializer::class.java)
    }
}