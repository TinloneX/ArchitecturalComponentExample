package com.tinlone.viewmodelexamplekotlin

import androidx.lifecycle.ViewModel

class HomeDataViewModel : ViewModel {
    var count = 0
    private var defaultConfig = "default"

    constructor() {}
    constructor(defaultConfig: String) {
        this.defaultConfig = defaultConfig
    }

    fun readConfig(): String {
        return defaultConfig
    }

    override fun onCleared() {
        super.onCleared()
        // 做流的关闭，资源回收
    }
}