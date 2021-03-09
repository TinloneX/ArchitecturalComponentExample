package com.tinlone.livedataexamplejava;

import androidx.lifecycle.LiveData;


public class MyPriceLiveData extends LiveData<Integer> {

    PriceManager.PriceListener listener = this::setValue;

    @Override
    protected void onActive() {
        PriceManager.getInstance().requestPriceUpdate(listener);
    }

    @Override
    protected void onInactive() {
        PriceManager.getInstance().removeUpdateListener(listener);
    }
}
