package com.tinlone.startupexamplekotlin.dependencies.database

import com.tinlone.startupexamplekotlin.dependencies.Logger

/**
 * 假设使用代理模式做 插拔式DatabaseHelper
 */
class DatabaseProxy private constructor() {
    fun insert(obj: Any?): Boolean {
        checkNotNull(dbHelper) { "IDatabaseHelper has not initialize" }
        return dbHelper!!.insert(obj)
    }

    private object Holder {
        val instance = DatabaseProxy()
    }

    companion object {
        private var dbHelper: IDatabaseHelper? = null
        fun initialize(config: IDatabaseHelper?) {
            // 仅做模拟
            dbHelper = config
        }

        fun getInstance(): DatabaseProxy {
            return Holder.instance
        }
    }

    init {
        Logger.log("loglog", "DatabaseProxy initialized")
    }
}