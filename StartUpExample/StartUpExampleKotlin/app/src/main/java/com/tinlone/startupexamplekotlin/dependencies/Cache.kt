package com.tinlone.startupexamplekotlin.dependencies

import com.tinlone.startupexamplekotlin.dependencies.database.DatabaseProxy

class Cache private constructor() {
    private object Holder {
        val instance = Cache()
    }

    companion object {
        var databaseProxy: DatabaseProxy? = null
        fun initialize(db: DatabaseProxy?) {
            databaseProxy = db
        }

        fun getInstance() :Cache{
            return Holder.instance
        }
    }

    init {
        Logger.log("loglog", "Cache initialized")
    }
}