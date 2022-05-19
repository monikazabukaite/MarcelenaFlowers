package com.prekes.web.prekesweb.model;

import java.util.Locale;

public class CountryList {

    public static void main(String[] args) {
        String[] countryCodes = Locale.getISOCountries();

        System.out.println("Number of countries and regions: " + countryCodes.length);

        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            System.out.printf("[%s] %s\n", code, name);
        }
    }

}
