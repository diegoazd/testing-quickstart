package com.quickstart.testing.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyPricingServiceTest {

    CurrencyPricingService currencyPricingService;

    @Mock
    PricingRepository pricingRepository = mock(PricingRepository.class);

    @Before
    public void initialize() {
        currencyPricingService = new CurrencyPricingService(pricingRepository);
    }

    @Test
    public void shouldGetExchangeRate() {
        when(pricingRepository.exchangeRate(Mockito.any(), Mockito.any())).
                thenReturn(BigDecimal.valueOf(18.925));

        Price price = new Price(BigDecimal.valueOf(10.0), new MexicoCurrency());
        final Price p = currencyPricingService.priceByCurrency(price, new UsaCurrency());

        assertTrue(BigDecimal.valueOf(189.25).compareTo(p.getPrice()) == 0);
    }


}