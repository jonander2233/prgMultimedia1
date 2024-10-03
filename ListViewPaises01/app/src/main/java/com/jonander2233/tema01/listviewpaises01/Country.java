package com.jonander2233.tema01.listviewpaises01;

public class Country {
    String countryCode;
    String countryName;
    int population;
    String capital;
    String isoAlpha3;

    public Country(String countryCode, String countryName, int population, String capital, String isoAlpha3) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.population = population;
        this.capital = capital;
        this.isoAlpha3 = isoAlpha3;
    }
}
