package com.worldpopulation;

public class Country {
    private String countryname, capitalname, regionname, subregioname;

    public Country(String countryname, String capitalname, String regionname, String subregioname) {
        this.countryname = countryname;
        this.capitalname = capitalname;
        this.regionname = regionname;
        this.subregioname = subregioname;
    }

    public String getCountryname() {
        return countryname;
    }

    public String getCapitalname() {
        return capitalname;
    }

    public String getRegionname() {
        return regionname;
    }

    public String getSubregioname() {
        return subregioname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryname='" + countryname + '\'' +
                ", capitalname='" + capitalname + '\'' +
                ", regionname='" + regionname + '\'' +
                ", subregioname='" + subregioname + '\'' +
                '}';
    }
}
