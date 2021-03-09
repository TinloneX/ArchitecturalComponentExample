package com.tinlone.livedataexamplekotlin

import androidx.lifecycle.*

class MyViewModel : ViewModel() {
    var price = MutableLiveData<Int?>()

    fun countUp() {
        price.value = price.value?.let { it + 1 } ?: let { 0 }
    }

    //==================为保证每个案例原汁原味===================
    private val priceManager: PriceManager = PriceManager.getInstance()
    var extensionData = MyPriceLiveData()

    fun updatePriceForExtension() {
        priceManager.updatePrice(priceManager.price + 1)
    }

    //==================为保证每个案例原汁原味===================
    var priceForMap = MutableLiveData<Int?>()

    var userThink = Transformations.map(
        priceForMap
    ) { price -> price?.toString() + if (price ?: let { 0 } % 2 == 0) "块刚刚好" else "块贵了" }

    fun setPriceForMap() {
        priceForMap.value = priceForMap.value?.let { it + 1 } ?: let { 0 }
    }

    //==================为保证每个案例原汁原味===================
    private var priceForSwitch = MutableLiveData<Int>()
    var sellerThink = MutableLiveData<String>()

    private fun getSellerThink(price: Int): MutableLiveData<String> {
        val think = price.toString() + if (price <= 3) "穷鬼" else "冤大头"
        sellerThink.value = think
        return sellerThink
    }

    fun setPriceForSeller() {
        priceForSwitch.value = priceForSwitch.value?.let { it + 1 } ?: let { 0 }
    }

    var switchToUserLook =
        Transformations.switchMap(priceForSwitch) { price -> getSellerThink(price) }

    //==================为保证每个案例原汁原味===================
    var priceForSeller = MutableLiveData<Int?>()
    var mSeller = MutableLiveData<Seller?>()

    private fun getSeller(price: Int?): MutableLiveData<Seller?> {
        val think = if (price ?: 0 <= 3) "$price 穷鬼" else "$price 冤大头"

        val seller: Seller = mSeller.value ?: Seller()

        seller.price = price ?: 0
        seller.think = think

        mSeller.value = seller
        return mSeller
    }

    fun setPriceToSeller() {
        priceForSeller.value = priceForSeller.value?.let { it + 1 } ?: let { 0 }
    }

    var switchToSeller: LiveData<Seller> =
        Transformations.switchMap(priceForSeller) { price -> getSeller(price) }

    //==================为保证每个案例原汁原味===================
    var mediatorLiveData = MediatorLiveData<Any>()
}