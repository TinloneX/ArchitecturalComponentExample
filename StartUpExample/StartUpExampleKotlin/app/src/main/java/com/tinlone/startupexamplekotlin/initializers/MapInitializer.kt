package com.tinlone.startupexamplekotlin.initializers

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.tinlone.startupexamplekotlin.dependencies.Logger
import com.tinlone.startupexamplekotlin.dependencies.TXMap

class MapInitializer : Initializer<TXMap> {
    override fun create(context: Context): TXMap {
        Logger.log("loglog", "create: MapInitializer")
        return TXMap()
    }

    override fun dependencies(): List<Class<out Initializer<*>?>> {
        // map依赖了log
        return listOf(LoggerInitializer::class.java, SomethingInitializer::class.java)
    }
}