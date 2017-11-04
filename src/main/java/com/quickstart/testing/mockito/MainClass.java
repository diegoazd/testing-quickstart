package com.quickstart.testing.mockito;

public class MainClass {
    private String param;
    Interaction interaction;

    public MainClass(String param) {
        this.param = param;
    }

    public int foo(int a) {
        //return interaction.complexMethod(a, param).length();

        final String concatenation = interaction.complexMethod(a, param);
        return concatenation == null ? 0 : concatenation.length();
    }
}
