package com.quickstart.testing.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldStubComplexInteractionTrueCase() {
        when(interaction.isFirstCase(Mockito.anyInt(), Mockito.anyInt(),
                Mockito.anyInt())).thenReturn(true);
        mainClass.complexInteraction(3, 7);

        verify(interaction, times(2))
                .method1(Mockito.anyInt());
        verify(interaction, times(0))
                .method2(Mockito.anyInt(), Mockito.anyInt());
        verify(interaction, times(0))
                .method3(Mockito.anyInt());
    }

    @Test
    public void shouldStubComplexInteractionFalseCase() {
        when(interaction.isFirstCase(Mockito.anyInt(), Mockito.anyInt(),
                Mockito.anyInt())).thenReturn(false);
        mainClass.complexInteraction(3, 7);

        verify(interaction, times(1))
                .method1(Mockito.anyInt());
        verify(interaction, times(1))
                .method2(Mockito.anyInt(), Mockito.anyInt());
        verify(interaction, times(1))
                .method3(Mockito.anyInt());
    }

}