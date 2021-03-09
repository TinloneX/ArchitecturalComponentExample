package com.tinlone.livedataexamplejava;

import java.util.ArrayList;

public final class PriceManager {
    ArrayList<PriceListener> mListeners = new ArrayList<>();
    int price;

    private PriceManager() {
    }

    private static final class Holder {
        public static final PriceManager INSTANCE = new PriceManager();
    }

    public static PriceManager getInstance() {
        return Holder.INSTANCE;
    }

    public void requestPriceUpdate(PriceListener listener) {
        mListeners.add(listener);
        listener.onPriceChanged(price);
    }

    public void removeUpdateListener(PriceListener listener) {
        mListeners.remove(listener);
    }

    public void updatePrice(int price) {
        this.price = price;
        dispatchPriceChanged();
    }

    private void dispatchPriceChanged() {
        for (PriceListener listener : mListeners) {
            listener.onPriceChanged(price);
        }
    }

    public interface PriceListener {
        void onPriceChanged(int price);
    }
}


