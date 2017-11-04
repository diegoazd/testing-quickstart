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

    public void complexInteraction(int a, int b) {
        final int c = a - b;

        interaction.method1(a);
        if(interaction.isFirstCase(a,b,c)) {
            interaction.method1(a);
        }else {
            interaction.method2(b, c);
            interaction.method3(c);
        }
    }
}
