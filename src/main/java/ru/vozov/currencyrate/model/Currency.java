package ru.vozov.currencyrate.model;

public enum Currency {
    USD(97.23),
    EUR(105.22),
    KZT(0.20),
    CNY(13.61),
    TRY(2.84);

    private final double rate;

    Currency(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
