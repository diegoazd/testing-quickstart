package com.quickstart.testing.mockito;

import java.math.BigDecimal;

public interface PricingRepository {
    BigDecimal exchangeRate(Currency currency, Currency currency2);
}
