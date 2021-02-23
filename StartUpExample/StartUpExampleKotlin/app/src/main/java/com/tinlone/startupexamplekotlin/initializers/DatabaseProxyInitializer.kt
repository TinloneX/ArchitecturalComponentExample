package com.tinlone.startupexamplekotlin.initializers

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.tinlone.startupexamplekotlin.dependencies.database.DatabaseHelper
import com.tinlone.startupexamplekotlin.dependencies.database.DatabaseProxy
import java.util.*

class DatabaseProxyInitializer : Initializer<DatabaseProxy?> {
    override fun create(context: Context): DatabaseProxy {
        Log.i("loglog", "create: DatabaseProxyInitializer")
        DatabaseProxy.initialize(DatabaseHelper.getInstance())
        return DatabaseProxy.getInstance()
    }

    override fun dependencies(): List<Class<out Initializer<*>?>> {
        return listOf(LoggerInitializer::class.java, DatabaseHelperInitializer::class.java)
    }
}