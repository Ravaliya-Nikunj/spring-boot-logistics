package com.example.logistics.dtos;

public class ServiceDTO {
    private String name;
    private String description;
    private double stairPrice;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStairPrice() {
        return stairPrice;
    }

    public void setStairPrice(double stairPrice) {
        this.stairPrice = stairPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "name='" + name + '\'' +
                ", description=" + description +
                ", stairPrice=" + stairPrice +
                ", image=" + image +
                '}';
    }
}
