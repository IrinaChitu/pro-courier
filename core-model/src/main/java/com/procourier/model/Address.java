package com.procourier.model;

import java.util.Objects;

public final class Address { //shift F6 pt redenumirea unei clase in IDE si update automat
    private String region;
    private String city;
    private String streetName;
    private String streetNumber;

    public Address(String region, String city, String streetName, String streetNumber) {
        this.region = Objects.requireNonNull(region);
        this.city = Objects.requireNonNull(city);
        this.streetName = Objects.requireNonNull(streetName);
        this.streetNumber = Objects.requireNonNull(streetNumber);
    }

    public Address(String region, String city, String streetName) {
        this(region, city, streetName, "");
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }
}
