package com.quickstart.testing.mockito;

import java.math.BigDecimal;
import java.util.List;

public class CurrencyPricingService implements PricingService {

    private PricingRepository pricingRepository;

    public CurrencyPricingService(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    @Override
    public Price priceByCurrency(Price price, Currency currency) {
        final BigDecimal exchangeRate = pricingRepository.exchangeRate(price.getCurrency(), currency);
        return new Price(price.getPrice().multiply(exchangeRate), currency);
    }

    @Override
    public Price totalPriceByCurrency(List<Price> prices, Currency currency) {
        Price total = new Price(BigDecimal.valueOf(0), currency);
        for(Price c: prices) {
            Price exchange = priceByCurrency(c, currency);
            total.setPrice(total.getPrice().add(exchange.getPrice()));
        }

        return total;
    }
}
