package com.tinlone.startupexamplekotlin.dependencies.database

import com.tinlone.startupexamplekotlin.dependencies.Logger
import java.lang.IllegalStateException

class DatabaseHelper private constructor() : IDatabaseHelper {
    override fun insert(obj: Any?): Boolean {
        return true
    }

    companion object {
        var config: String  ?= null

        fun init() {
            config = "init"
        }

        fun getInstance(): DatabaseHelper  {
            if (config == null){
                throw IllegalStateException("config has no init")
            }
            return DatabaseHelper()
        }
    }

    init {
        Logger.log("loglog", "DatabaseHelper initialized")
    }
}