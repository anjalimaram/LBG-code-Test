package com.example.config;


import static com.example.config.Constants.COMMA;
import static com.example.config.Constants.TAB;

public enum Configurate {
    CREDIT_DATA_FILE("data/input.txt", TAB),
    EXCHANGE_RATES_FILE("config/exchangeRates.csv", COMMA);

    private final String filePath;
    private final String delimiter;


    FileConfig(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getDelimiter() {
        return this.delimiter;
    }


}
