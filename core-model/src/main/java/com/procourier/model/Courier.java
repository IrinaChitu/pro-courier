package com.procourier.model;

import java.util.Objects;

public final class Courier {
    private Long ID;
    private String companyName;
    private Address headquarters;
    private Long distancePrice;
    private Long weightPrice;

    public Courier(Long ID, String companyName, Address headquarters, Long distancePrice, Long weightPrice) {
        this.ID = Objects.requireNonNull(ID);
        this.companyName = Objects.requireNonNull(companyName);
        this.headquarters = Objects.requireNonNull(headquarters);
        this.distancePrice = Objects.requireNonNull(distancePrice);
        this.weightPrice = Objects.requireNonNull(weightPrice);
    }

    public Long getID() {
        return ID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Address getHeadquarters() {
        return headquarters;
    }

    public Long getDistancePrice() {
        return distancePrice;
    }

    public Long getWeightPrice() {
        return weightPrice;
    }

}
