package com.tinlone.startupexamplekotlin.dependencies

import android.util.Log
import java.util.*

/**
 * 模拟使用前必须初始化
 */
class Logger private constructor() {
    private object Holder {
        val instance = Logger()
    }

    companion object {
        private var tagsShow: HashMap<String, Boolean>? = null
        fun initialize() {
            // 仅做模拟
            tagsShow = HashMap()
        }

        private fun canShow(tag: String, show: Boolean): Boolean {
            checkNotNull(tagsShow) { "Logger has not initialize" }
            val canShow = tagsShow!![tag]
            return canShow ?: show
        }

        @JvmOverloads
        fun log(tag: String, msg: String?, show: Boolean = true) {
            if (canShow(tag, show)) {
                Log.i(tag, msg!!)
            }
        }

        fun getInstance(): Logger {
            return Holder.instance
        }
    }

    init {
        log("loglog", "Logger initialized")
    }
}