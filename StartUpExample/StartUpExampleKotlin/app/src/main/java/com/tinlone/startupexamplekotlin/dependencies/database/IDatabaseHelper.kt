package com.tinlone.startupexamplekotlin.dependencies.database

interface IDatabaseHelper {
    fun insert(obj: Any?): Boolean
}