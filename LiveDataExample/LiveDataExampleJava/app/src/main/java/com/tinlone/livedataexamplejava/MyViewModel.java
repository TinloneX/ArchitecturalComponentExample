package com.tinlone.livedataexamplejava;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    MutableLiveData<Integer> price = new MutableLiveData<>();

    public void countUp() {
        if (price.getValue() == null) {
            price.setValue(0);
        }
        price.setValue(price.getValue() + 1);
    }

    //==================为保证每个案例原汁原味===================
    private final PriceManager priceManager = PriceManager.getInstance();
    MyPriceLiveData extensionData = new MyPriceLiveData();

    public void updatePriceForExtension() {
        priceManager.updatePrice(priceManager.price + 1);
    }

    //==================为保证每个案例原汁原味===================

    MutableLiveData<Integer> priceForMap = new MutableLiveData<>();

    LiveData<String> userThink = Transformations.map(priceForMap,
            price -> price + (price % 2 == 0 ? "块刚刚好" : "块贵了"));

    public void setPriceForMap() {
        if (priceForMap.getValue() == null) {
            priceForMap.setValue(0);
        }
        priceForMap.setValue(priceForMap.getValue() + 1);
    }

    //==================为保证每个案例原汁原味===================
    MutableLiveData<Integer> priceForSwitch = new MutableLiveData<>();

    MutableLiveData<String> sellerThink = new MutableLiveData<>();

    private MutableLiveData<String> getSellerThink(int price) {
        String think = price + (price <= 3 ? "穷鬼" : "冤大头");
        sellerThink.setValue(think);
        return sellerThink;
    }

    public void setPriceForSeller() {
        if (priceForSwitch.getValue() == null) {
            priceForSwitch.setValue(0);
        }
        priceForSwitch.setValue(priceForSwitch.getValue() + 1);
    }

    LiveData<String> switchToUserLook = Transformations.switchMap(priceForSwitch, this::getSellerThink);

    //==================为保证每个案例原汁原味===================
    MutableLiveData<Integer> priceForSeller = new MutableLiveData<>();

    MutableLiveData<Seller> mSeller = new MutableLiveData<>();

    private MutableLiveData<Seller> getSeller(int price) {
        String think = price + (price <= 3 ? "穷鬼" : "冤大头");
        Seller seller;
        if (mSeller.getValue() == null) {
            seller = new Seller();
        } else {
            seller = mSeller.getValue();
        }
        seller.price = price;
        seller.think = think;
        mSeller.setValue(seller);
        return mSeller;
    }

    public void setPriceToSeller() {
        if (priceForSeller.getValue() == null) {
            priceForSeller.setValue(0);
        }
        priceForSeller.setValue(priceForSeller.getValue() + 1);
    }

    LiveData<Seller> switchToSeller = Transformations.switchMap(priceForSeller, this::getSeller);

    //==================为保证每个案例原汁原味===================
    MediatorLiveData<Object> mediatorLiveData = new MediatorLiveData<>();


}
