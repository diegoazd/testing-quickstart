package com.quickstart.testing.mockito;

import java.util.List;

public interface PricingService {

    Price priceByCurrency(Price price, Currency currency);
    Price totalPriceByCurrency(List<Price> prices, Currency currency);
}
