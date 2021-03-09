package com.tinlone.livedataexamplekotlin

import java.util.*

class PriceManager private constructor() {
    var mListeners = ArrayList<PriceListener>()
    var price = 0

    private object Holder {
        val instance = PriceManager()
    }

    fun requestPriceUpdate(listener: PriceListener) {
        mListeners.add(listener)
        listener.onPriceChanged(price)
    }

    fun removeUpdateListener(listener: PriceListener) {
        mListeners.remove(listener)
    }

    fun updatePrice(price: Int) {
        this.price = price
        dispatchPriceChanged()
    }

    private fun dispatchPriceChanged() {
        for (listener in mListeners) {
            listener.onPriceChanged(price)
        }
    }


    companion object {

        fun getInstance(): PriceManager {
           return Holder.instance
        }
    }
}