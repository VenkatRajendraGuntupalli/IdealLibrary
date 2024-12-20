package com.example.IdealLibrary.dto;

import java.time.LocalDate;

public class BookDTO {
    private Long id;
    private String name;
    private String author;
    private LocalDate publishDate;
    private Double price;
    private String type;
    private String suitableForAges;
    private String genre;

    // Default constructor
    public BookDTO() {}

    // Constructor with parameters
    public BookDTO(Long id, String name, String author, LocalDate publishDate, Double price, String type, String suitableForAges, String genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.price = price;
        this.type = type;
        this.suitableForAges = suitableForAges;
        this.genre = genre;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getSuitableForAges() {
        return suitableForAges;
    }

    public String getGenre() {
        return genre;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSuitableForAges(String suitableForAges) {
        this.suitableForAges = suitableForAges;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
