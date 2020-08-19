package com.example.data;

public class CreditRates implements Key {

    private String countryCriteria ;
    private String creditRatingCriteria;

    public CreditRates(String countryCriteria, String creditRatingCriteria) {
        this.countryCriteria = countryCriteria;
        this.creditRatingCriteria = creditRatingCriteria;
    }

    public String getCountryCriteria() {
        return countryCriteria;
    }

    public String getCreditRatingCriteria() {
        return creditRatingCriteria;
    }
}
