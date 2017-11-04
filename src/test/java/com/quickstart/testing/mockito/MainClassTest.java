package com.quickstart.testing.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainClassTest {
    MainClass mainClass;
    Interaction interaction;

    @Before
    public void initialize() {
        mainClass = new MainClass("abcdefg");
        interaction = mock(Interaction.class);
        mainClass.interaction = interaction;
    }

    @Test
    public void shouldMockInteractionClass() {
        when(interaction.complexMethod(Mockito.anyInt(),Mockito.anyString()))
                .thenReturn("a 1");

        assertEquals(3, mainClass.foo(2));
    }

    @Test
    public void shouldMockInteractionWithNull() {
        when(interaction.complexMethod(Mockito.anyInt(),Mockito.anyString()))
                .thenReturn(null);

        assertEquals(0, mainClass.foo(2));
    }


}