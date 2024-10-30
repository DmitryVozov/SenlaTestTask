package ru.vozov.currencyrate.service;

import ru.vozov.currencyrate.helper.ConsoleHelper;
import ru.vozov.currencyrate.model.Currency;

import java.io.IOException;

public class CurrencyRateService {
    public Double getSumCurrency() {
        while(true) {
            try {
                ConsoleHelper.writeMessage("Введите сумму в рублях, которую необходимо конвертировать в другие валюты: ");
                double sumRub = ConsoleHelper.readDouble();

                if (sumRub <= 0) {
                    ConsoleHelper.writeMessage("Сумма должна быть больше нуля.");
                    continue;
                }

                return sumRub;
            }
            catch (IOException | NumberFormatException e) {
                ConsoleHelper.writeMessage(
                        "Ошибка при вводе суммы, вводите только числовые значения. Если число с дробной частью, то ее необходимо разделить от целой части точкой. Например, 5.31"
                );
            }
        }
    }

    public void convertCurrencies(Double sumRub) {
        Currency[] currencies = Currency.values();

        for (Currency currency : currencies) {
            showConvertedCurrency(sumRub, sumRub / currency.getRate(), currency);
        }
    }

    private void showConvertedCurrency(double sumRub, double convertedCurrency, Currency currency) {
        ConsoleHelper.writeMessage(
                String.format(
                        "%f RUB = %f %s",
                        sumRub,
                        convertedCurrency,
                        currency.toString()
                )
        );
    }
}
