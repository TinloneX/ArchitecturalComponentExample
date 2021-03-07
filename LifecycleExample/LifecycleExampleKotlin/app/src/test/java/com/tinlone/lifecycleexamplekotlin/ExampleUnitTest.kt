package com.tinlone.lifecycleexamplekotlin

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private var observer: ProcessLifecycleObserver? = null

    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        print(isForeground())
        if (isForeground() != true) {
            print("ok")
        } else {
            print("no")
        }

    }

    private fun isForeground(): Boolean? {
        return observer?.isForeground()
    }

}