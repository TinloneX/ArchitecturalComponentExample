package com.tinlone.startupexamplekotlin.initializers

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.tinlone.startupexamplekotlin.dependencies.database.DatabaseHelper
import com.tinlone.startupexamplekotlin.dependencies.database.IDatabaseHelper

class DatabaseHelperInitializer : Initializer<IDatabaseHelper?> {
    override fun create(context: Context): IDatabaseHelper {
        Log.i("loglog", "create: DatabaseHelperInitializer")
        DatabaseHelper.init()
        return DatabaseHelper.getInstance()
    }

    override fun dependencies(): List<Class<out Initializer<*>?>> {
        return listOf(LoggerInitializer::class.java)
    }
}