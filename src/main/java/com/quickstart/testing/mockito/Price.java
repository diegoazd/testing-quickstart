package com.quickstart.testing.mockito;

import java.math.BigDecimal;

public class Price {

    private BigDecimal price;
    private Currency currency;

    public Price(BigDecimal price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }
}
