package com.company.spring_jsp.data.entity;

//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    enum Gender {
        MEN, WOMEN, UNISEX, KIDS
    }

    enum Category {
        CASUAL, RUNNING, HIKING, TRAINING, BASKETBALL, BOOTS, SANDALS
    }

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "star_rating", columnDefinition = "decimal", precision = 2, scale = 1)
    private Double starRating;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "description")
    private String description;

    // Constructors
    public Item() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getStarRating() {
        return starRating;
    }

    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Methods
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", category=" + category +
                ", starRating=" + starRating +
                ", reviewCount=" + reviewCount +
                ", description='" + description + '\'' +
                '}';
    }

}
