package com.quickstart.testing.unit;

import com.quickstart.testing.mock.rest.RestServiceTest;
import com.quickstart.testing.mockito.CurrencyPricingServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({FixturesTest.class, ComplexObjectTest.class,
        CurrencyPricingServiceTest.class, RestServiceTest.class})
public class TestSuite {
}
