package com.ag.config;

import com.example.data.ExgRate;
import com.example.load.DeliminateFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public enum ExRates {
    INSTANCE(EXCHANGE_RATES_FILE);

    private Map<String, ExchangeRate> exchangeRatesMap = new HashMap<>();

    ExRates(FileConfig exchangeRatesFileConfig) {
        DelimitedFileLoader<ExchangeRate> exchangeRatesLoader = new DelimitedFileLoader<>(EXCHANGE_RATES_FILE.getFilePath());
        try {
            exchangeRatesLoader.loadData((line) -> {
                String[] row = line.split(EXCHANGE_RATES_FILE.getDelimiter());
                return new ExchangeRate(row);

            }).forEach(exchangeRate -> exchangeRatesMap.put(exchangeRate.getFromCurrency(), exchangeRate));

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }

    }

    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        ExchangeRate toUSDRate = this.exchangeRatesMap.computeIfAbsent(fromCurrency, (from)->new ExchangeRate());
        Double amountInUSD = amount * toUSDRate.getRate();
        ExchangeRate toCurrencyRate = this.exchangeRatesMap.computeIfAbsent(toCurrency, (to)->new ExchangeRate());
        return amountInUSD / toCurrencyRate.getRate();

    }

}
