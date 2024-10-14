package com.online.bet.system.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Rate {

    public static final Rate ZERO = new Rate(BigDecimal.ZERO);
    private final BigDecimal rate;

    public Rate(BigDecimal rate) {
        this.rate = setScale(rate);
    }

    public boolean isGreaterThanZero() {
        return this.rate != null && this.rate.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Rate rate) {
        return this.rate != null && this.rate.compareTo(rate.getRate()) > 0;
    }

    public BigDecimal generateRandomRate() {
        return setScale(BigDecimal.valueOf(1.0 + (3.0 - 1.0) * Math.random()));
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate money = (Rate) o;
        return rate.equals(money.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
