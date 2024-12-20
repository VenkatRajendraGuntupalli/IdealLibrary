package com.example.IdealLibrary.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private LocalDate publishDate;
    private Double price;
    private String type;
    private String suitableForAges;
    private String genre;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for publishDate
    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    // Getter and Setter for price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for suitableForAges
    public String getSuitableForAges() {
        return suitableForAges;
    }

    public void setSuitableForAges(String suitableForAges) {
        this.suitableForAges = suitableForAges;
    }

    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
