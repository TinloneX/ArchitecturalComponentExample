package com.tinlone.viewmodelexamplejava;

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



    }


    static class A {
        public instanceA ia = new instanceA();

        static final class instanceA{
            Object a;
        }

    }

    static class B extends A{

        static final class instanceA{
            String b;
        }

        void doCast(){
            instanceA iba = (instanceA) ia.a;
        }

    }

}