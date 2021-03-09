package com.tinlone.livedataexamplejava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LiveDataExampleLog";
    private Button btnObserver;
    private Button btnExtension;
    private Button btnTransform;
    private Button btnTransformSwitch;
    private Button btnSwitchSeller;
    private Button btnMediator;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        btnObserver = findViewById(R.id.btn_observer);
        btnExtension = findViewById(R.id.btn_extension);
        btnTransform = findViewById(R.id.btn_transform);
        btnTransformSwitch = findViewById(R.id.btn_transform_switch);
        btnSwitchSeller = findViewById(R.id.btn_switch_seller);
        btnMediator = findViewById(R.id.btn_mediator);

        // 建立订阅关系
        viewModel.price.observe(this, this::updatePriceButton);
        // 数据转换 订阅价格的转换 => 用户价格感知
        viewModel.userThink.observe(this, this::updateUserThinkButton);
        // 数据转换switchMap 被转换数据的观察
        viewModel.switchToUserLook.observe(this, this::updateSellerThinkButton);
        // 数据转换 switchMap 对数据转换结果的观察
        viewModel.sellerThink.observe(this, (text) -> Log.i(TAG, "我是商家想法的订阅：" + text));
        // 数据转化为对象 比较对象与结果的hashCOde
        viewModel.switchToSeller.observe(this, this::equalSellerHashCode);
        // LiveData扩展
        viewModel.extensionData.observe(this, this::updateExtensionButton);
        // 合并观察1
        viewModel.mediatorLiveData.addSource(viewModel.switchToSeller, this::onMediatorData);
        // 合并观察2
        viewModel.mediatorLiveData.addSource(viewModel.userThink, this::onMediatorData);
    }

    /**
     * 简单订阅数据
     */
    public void countUp(View view) {
        viewModel.countUp();
    }

    /**
     * 扩展LiveData
     */
    public void extensionData(View view) {
        viewModel.updatePriceForExtension();
    }

    /**
     * 通过map转换数据
     */
    public void transformByMap(View view) {
        viewModel.setPriceForMap();
    }

    /**
     * 通过switchMap转换数据
     */
    public void transformBySwitchMap(View view) {
        viewModel.setPriceForSeller();
    }

    /**
     * 数据转换为Object，验证Object.hashCode()
     */
    public void transformBySwitchMapForSeller(View view) {
        viewModel.setPriceToSeller();
    }

    boolean mediatorFlag = false;

    /**
     * 合并数据
     */
    public void mediatorData(View view) {
        if (mediatorFlag) {
            viewModel.setPriceToSeller();
        } else {
            viewModel.setPriceForMap();
        }
        mediatorFlag = !mediatorFlag;
    }

    /**
     * 更新界面 - 第一个按钮
     */
    private void updatePriceButton(int price) {
        String text = String.format("订阅数据变化\uD83D\uDC49 %s", price);
        btnObserver.setText(text);
        Log.i(TAG, text);
    }

    /**
     * 更新界面 - 第二个按钮
     */
    private void updateExtensionButton(int price) {
        String text = String.format("测试扩展LiveData\uD83D\uDC49 %s", price);
        btnExtension.setText(text);
        Log.i(TAG, text);
    }

    /**
     * 更新界面 - 第三个按钮
     */
    private void updateUserThinkButton(String userThink) {
        String text = String.format("转换数据(map)\uD83D\uDC49 %s", userThink);
        btnTransform.setText(text);
        Log.i(TAG, text);
    }

    /**
     * 更新界面 - 第四个按钮
     */
    private void updateSellerThinkButton(String sellerThink) {
        String text = String.format("转换数据(switchMap)\uD83D\uDC49 %s", sellerThink);
        btnTransformSwitch.setText(text);
        Log.i(TAG, text);
    }

    /**
     * 更新界面 - 第五个按钮
     */
    private void equalSellerHashCode(Seller seller) {
        int mSellerHash = viewModel.mSeller.getValue().hashCode();
        int switchSellerHash = viewModel.switchToSeller.getValue().hashCode();

        Log.i(TAG, String.format("订阅的Seller.hashCode() = %s", seller.hashCode()));

        Log.i(TAG, String.format("viewModel.mSeller.getValue().hashCode() = %s", mSellerHash));

        Log.i(TAG, String.format("viewModel.switchToSeller.getValue().hashCode() = %s", switchSellerHash));
        btnSwitchSeller.setText(String.format("转换数据Object版 是否是同一个对象：%s",
                mSellerHash == switchSellerHash));
    }

    /**
     * 更新界面 - 合并数据
     */
    private void onMediatorData(Object object) {
        String text = String.format("合并数据\uD83D\uDC49 %s", object);
        Log.i(TAG, text);
        btnMediator.setText(text);
    }

}