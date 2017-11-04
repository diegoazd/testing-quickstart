package com.quickstart.testing.unit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexObjectTest {

    private ComplexObject complexObject;

    @Before
    public void initialize() {
        complexObject = new ComplexObject("this", "is", "sparta");
    }

    @Test
    public void shouldAssertEquals() {
       ComplexObject another = new ComplexObject("this", "is", "sparta");
       assertEquals(complexObject, another);
       assertEquals("this is sparta", another.toString());
    }

}