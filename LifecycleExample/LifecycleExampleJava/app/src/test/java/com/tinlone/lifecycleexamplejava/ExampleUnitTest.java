package com.tinlone.lifecycleexamplejava;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);

        System.out.println("Number.ONE.isAtLeast(Number.TWO) ? " + Number.ONE.isAtLeast(Number.TWO));
        System.out.println("Number.TWO.isAtLeast(Number.ONE) ? " + Number.TWO.isAtLeast(Number.ONE));
        System.out.println("Number.THREE.isAtLeast(Number.ONE) ? " + Number.THREE.isAtLeast(Number.ONE));
        System.out.println("Number.THREE.isAtLeast(Number.FOUR) ? " + Number.THREE.isAtLeast(Number.FOUR));

        System.out.println(Number.ONE.ordinal());
        System.out.println(Number.TWO.ordinal());
        System.out.println(Number.THREE.ordinal());
        System.out.println(Number.FOUR.ordinal());

        System.out.println(Number.valueOf("ONE"));
        System.out.println(Number.values()[0]);

    }


    enum Number{

        ONE,

        TWO,

        THREE,

        FOUR;



        public boolean isAtLeast(@NonNull Number number) {
            return compareTo(number) >= 0;
        }

    }


}