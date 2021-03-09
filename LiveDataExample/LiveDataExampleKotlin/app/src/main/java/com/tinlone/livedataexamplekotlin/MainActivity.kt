package com.tinlone.livedataexamplekotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var btnObserver: Button
    private lateinit var btnExtension: Button
    private lateinit var btnTransform: Button
    private lateinit var btnTransformSwitch: Button
    private lateinit var btnSwitchSeller: Button
    private lateinit var btnMediator: Button
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        btnObserver = findViewById(R.id.btn_observer)
        btnExtension = findViewById(R.id.btn_extension)
        btnTransform = findViewById(R.id.btn_transform)
        btnTransformSwitch = findViewById(R.id.btn_transform_switch)
        btnSwitchSeller = findViewById(R.id.btn_switch_seller)
        btnMediator = findViewById(R.id.btn_mediator)

        // 建立订阅关系
        viewModel.price.observe(this) { price -> updatePriceButton(price) }
        // 数据转换 订阅价格的转换 => 用户价格感知
        viewModel.userThink.observe(this) { userThink -> updateUserThinkButton(userThink) }
        // 数据转换switchMap 被转换数据的观察
        viewModel.switchToUserLook.observe(this) { sellerThink ->
            updateSellerThinkButton(
                sellerThink
            )
        }
        // 数据转换 switchMap 对数据转换结果的观察
        viewModel.sellerThink.observe(this) { text -> Log.i(TAG, "我是商家想法的订阅：$text") }
        // 数据转化为对象 比较对象与结果的hashCOde
        viewModel.switchToSeller.observe(this) { seller -> equalSellerHashCode(seller) }
        // LiveData扩展
        viewModel.extensionData.observe(this) { price -> updateExtensionButton(price) }
        // 合并观察1
        viewModel.mediatorLiveData.addSource(viewModel.switchToSeller) { data -> onMediatorData(data) }
        // 合并观察2
        viewModel.mediatorLiveData.addSource(viewModel.userThink) { data -> onMediatorData(data) }
    }

    /**
     * 简单订阅数据
     */
    fun countUp(view: View) {
        viewModel.countUp()
    }

    /**
     * 扩展LiveData
     */
    fun extensionData(view: View) {
        viewModel.updatePriceForExtension()
    }

    /**
     * 通过map转换数据
     */
    fun transformByMap(view: View) {
        viewModel.setPriceForMap()
    }

    /**
     * 通过switchMap转换数据
     */
    fun transformBySwitchMap(view: View) {
        viewModel.setPriceForSeller()
    }

    /**
     * 数据转换为Object，验证Object.hashCode()
     */
    fun transformBySwitchMapForSeller(view: View) {
        viewModel.setPriceToSeller()
    }

    var mediatorFlag = false

    /**
     * 合并数据
     */
    fun mediatorData(view: View) {
        if (mediatorFlag) {
            viewModel.setPriceToSeller()
        } else {
            viewModel.setPriceForMap()
        }
        mediatorFlag = !mediatorFlag
        Log.i(TAG, "mediatorFlag: $mediatorFlag")
    }

    /**
     * 更新界面 - 第一个按钮
     */
    private fun updatePriceButton(price: Int?) {
        val text = String.format("订阅数据变化\uD83D\uDC49 %s", price)
        btnObserver.text = text
        Log.i(TAG, text)
    }

    /**
     * 更新界面 - 第二个按钮
     */
    private fun updateExtensionButton(price: Int?) {
        val text = String.format("测试扩展LiveData\uD83D\uDC49 %s", price)
        btnExtension.text = text
        Log.i(TAG, text)
    }

    /**
     * 更新界面 - 第三个按钮
     */
    private fun updateUserThinkButton(userThink: String) {
        val text = String.format("转换数据(map)\uD83D\uDC49 %s", userThink)
        btnTransform.text = text
        Log.i(TAG, text)
    }

    /**
     * 更新界面 - 第四个按钮
     */
    private fun updateSellerThinkButton(sellerThink: String) {
        val text = String.format("转换数据(switchMap)\uD83D\uDC49 %s", sellerThink)
        btnTransformSwitch.text = text
        Log.i(TAG, text)
    }

    /**
     * 更新界面 - 第五个按钮
     */
    private fun equalSellerHashCode(seller: Seller) {
        val mSellerHash = viewModel.mSeller.value.hashCode()
        val switchSellerHash = viewModel.switchToSeller.value.hashCode()
        Log.i(TAG, java.lang.String.format("订阅的Seller.hashCode() = %s", seller.hashCode()))
        Log.i(TAG, String.format("viewModel.mSeller.getValue().hashCode() = %s", mSellerHash))
        Log.i(
            TAG,
            String.format("viewModel.switchToSeller.getValue().hashCode() = %s", switchSellerHash)
        )
        btnSwitchSeller.text = String.format(
            "转换数据Object版 是否是同一个对象：%s",
            mSellerHash == switchSellerHash
        )
    }

    /**
     * 更新界面 - 合并数据
     */
    private fun onMediatorData(`object`: Any) {
        val text = String.format("合并数据\uD83D\uDC49 %s", `object`)
        Log.i(TAG, text)
        btnMediator.text = text
    }

    companion object {
        private const val TAG = "LiveDataExampleLog"
    }
}