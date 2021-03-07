package com.tinlone.viewmodelexamplekotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(defaultConfig: String) : ViewModelProvider.Factory {
    private var defaultConfig = ""
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeDataViewModel(defaultConfig) as T
    }

    init {
        this.defaultConfig = defaultConfig
    }
}