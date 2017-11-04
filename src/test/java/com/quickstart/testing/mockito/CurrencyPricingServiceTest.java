package com.quickstart.testing.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
    @Test
    public void shouldTotalPriceByCurrency() {
        when(pricingRepository.exchangeRate(Mockito.any(), Mockito.any())).
                thenReturn(BigDecimal.valueOf(18.925));

        List<Price> prices = new ArrayList<>();
        prices.add(new Price(BigDecimal.valueOf(20.0), new MexicoCurrency()));
        prices.add(new Price(BigDecimal.valueOf(25.0), new MexicoCurrency()));
        prices.add(new Price(BigDecimal.valueOf(30.0), new MexicoCurrency()));
        prices.add(new Price(BigDecimal.valueOf(35.0), new MexicoCurrency()));

        final Price p = currencyPricingService.totalPriceByCurrency(prices, new UsaCurrency());

        verify(pricingRepository, times(4)).
                exchangeRate(Mockito.any(), Mockito.any());
        assertTrue(BigDecimal.valueOf(2081.75).compareTo(p.getPrice()) == 0);
    }

    @Test
    public void shouldTotal0() {
        List<Price> emptyPrices = new ArrayList<>();
        final Price p = currencyPricingService.totalPriceByCurrency(emptyPrices, new UsaCurrency());

        verify(pricingRepository, times(0)).
                exchangeRate(Mockito.any(), Mockito.any());
        assertTrue(BigDecimal.valueOf(0).compareTo(p.getPrice()) == 0);
    }

    @Test
    public void shouldSpyList() {
        List<String> list = new ArrayList<>();
        List<String> spy = spy(list);

        doReturn("foo").when(spy).get(0);
        assertEquals("foo", spy.get(0));
    }

}