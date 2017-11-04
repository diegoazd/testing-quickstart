package com.quickstart.testing.unit;


import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FixturesTest {
   private int a;
   private int b;
   private Unit unit = new Unit();

   @Before
   public void initialize() {
      a=4;
      b=7;
   }

   @Test
   public void shouldAdd2Numbers() {
      assertEquals(11, unit.add(a,b));

      a = 99;
      b = 1;

      assertEquals(100, unit.add(a,b));
   }

   @Test
   public void shouldRunBeforeAnnotation() {
      assertEquals(28, unit.multiply(a,b));
   }

   @Test
   public void shouldAssertEqualsTrue() {
      assertTrue( a < b);
   }

   @Test
   public void shouldAssertEqualsFalse() {
      assertFalse(b < a);
   }

   @Test
   public void shouldAssertArray() {
      int[] fixture = new int[] {1,2,3};
      assertArrayEquals(fixture, unit.toArray(1,2,3));
   }

   @Test
   public void shouldAssertObject() {
      List<Integer> numbers = Arrays.asList(1,2,3);
      assertEquals( numbers, unit.toList(1,2,3));
   }
}