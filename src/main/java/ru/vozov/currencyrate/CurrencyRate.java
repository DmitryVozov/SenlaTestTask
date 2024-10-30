package ru.vozov.currencyrate;

import ru.vozov.currencyrate.service.CurrencyRateService;

public class CurrencyRate {
    private static final CurrencyRateService currencyRateService = new CurrencyRateService();

    public static void main(String[] args) {
       double sumRub = currencyRateService.gi();
       currencyRateService.convertCurrencies(sumRub);
    }
}
