package com.example.IdealLibrary.dto;

import java.time.LocalDate;

public class BorrowRecordDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Double bookPrice;

    // Default constructor
    public BorrowRecordDTO() {}

    // Constructor with parameters
    public BorrowRecordDTO(Long id, Long userId, Long bookId, LocalDate borrowDate, LocalDate returnDate, Double bookPrice) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.bookPrice = bookPrice;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter and Setter for bookId
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // Getter and Setter for borrowDate
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    // Getter and Setter for returnDate
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    // Getter and Setter for bookPrice
    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
