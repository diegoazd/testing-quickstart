package com.quickstart.testing.mockito;

public class Interaction {

    public String complexMethod(int a, String b) {
        return b+": "+a;
    }

    public boolean isFirstCase(int a, int b, int c) {
        a = b * c;
        b = a - c;
        c = a - c + 20;
        a = a + b / c;
        return a > b + c;
    }

    public void method1(int a) {
    }

    public void method2(int b, int c) {
    }

    public void method3(int c) {
    }
}
