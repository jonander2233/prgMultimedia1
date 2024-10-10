package com.jonander2233.listviewpaisesconviewholder;

public class Country {
    private final String countryName;
    private final int population;
    private final String capital;
    private final String countryCode;

    public Country(String countryCode, String countryName, int population, String capital) {
        this.countryName = countryName;
        this.population = population;
        this.capital = capital;
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getIsoAlpha3() {
        return countryCode;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
