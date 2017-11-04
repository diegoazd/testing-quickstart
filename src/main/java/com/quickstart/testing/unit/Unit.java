package com.quickstart.testing.unit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Unit {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int[] toArray(int ... values) {
       return values;
    }

    public List<Integer> toList(int ... values) {
        return Arrays.stream(values).boxed().collect(Collectors.toList());
    }
}
