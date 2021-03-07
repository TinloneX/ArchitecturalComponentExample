package com.tinlone.viewmodelexamplejava;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelFactory implements ViewModelProvider.Factory {

   private String defaultConfig = "";

    public MyViewModelFactory(String defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeDataViewModel(defaultConfig);
    }
}
