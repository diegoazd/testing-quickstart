package com.quickstart.testing.unit;

import com.quickstart.testing.mockito.MainClassTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({FixturesTest.class, ComplexObjectTest.class,
        MainClassTest.class})
public class TestSuite {
}
