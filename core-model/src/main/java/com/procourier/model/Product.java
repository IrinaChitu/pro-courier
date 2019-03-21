package com.procourier.model;

import java.util.Objects;

public final class Product {
    private Long price;
    private String name;
    private String description;
    private Long weight;

    public Product(Long price, String name, String description, Long weight) {
        this.price = Objects.requireNonNull(price);
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.weight = checkWeight(weight);
    }

    private static Long checkWeight(Long weight) {
        if(weight <= 0) {
            throw new IllegalArgumentException("Weight must pe positive");
        }
        return Objects.requireNonNull(weight);
    }

    public Long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getWeight() {
        return weight;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        final Product product = new Product(12L, null, "Some prod", 22L);
    }

}
