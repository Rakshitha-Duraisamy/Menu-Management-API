package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="menu")
public class Food {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank
    String name;
    double price;
    String category;
    boolean availability;

    public Food() {}
    public Food(@JsonProperty("id") long id, @JsonProperty("name") String name,@JsonProperty("price") double price,@JsonProperty("category") String category, @JsonProperty("availability") boolean availability)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
        this.availability=availability;
    }

    public long getId() {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setCategory(String category) {
    }

    public void setName(String name) {
    }

    public void setPrice(double price) {
    }

    public void setAvailability(boolean availability) {
    }
}
