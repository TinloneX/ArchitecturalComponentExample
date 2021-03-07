package com.tinlone.viewmodelexamplejava;

import androidx.lifecycle.ViewModel;

public class HomeDataViewModel extends ViewModel {

    public int count = 0;

    private String defaultConfig = "default";

    public HomeDataViewModel() {
    }

    public HomeDataViewModel(String defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public String readConfig(){
        return defaultConfig;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        // 做流的关闭，资源回收
    }
}
