package com.quickstart.testing.unit;

public class ComplexObject {
    private String param1;
    private String param2;
    private String param3;

    public ComplexObject(String param1, String param2,
                         String param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    @Override
    public String toString() {
        return param1 + " " + param2 + " " + param3;
    }

    @Override
    public boolean equals(Object other) {
       return this.toString().equals(other.toString());
    }
}
