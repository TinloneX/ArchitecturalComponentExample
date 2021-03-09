package com.tinlone.livedataexamplekotlin

import androidx.lifecycle.LiveData

class MyPriceLiveData : LiveData<Int?>() {

    var listener: PriceListener = object : PriceListener {
        override fun onPriceChanged(price: Int) {
            value = price
        }
    }

    override fun onActive() {
        super.onActive()
        PriceManager.getInstance().requestPriceUpdate(listener)
    }

    override fun onInactive() {
        super.onInactive()
        PriceManager.getInstance().removeUpdateListener(listener)
    }
}