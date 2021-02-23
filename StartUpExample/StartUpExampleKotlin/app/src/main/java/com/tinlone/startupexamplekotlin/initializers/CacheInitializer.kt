package com.tinlone.startupexamplekotlin.initializers

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.tinlone.startupexamplekotlin.dependencies.Cache
import com.tinlone.startupexamplekotlin.dependencies.database.DatabaseProxy

class CacheInitializer : Initializer<Cache> {
    override fun create(context: Context): Cache {
        Log.i("loglog", "create: CacheInitializer")
        Cache.initialize(DatabaseProxy.getInstance())
        return Cache.getInstance()
    }

    override fun dependencies(): List<Class<out Initializer<*>?>> {
        return listOf(DatabaseProxyInitializer::class.java)
    }
}