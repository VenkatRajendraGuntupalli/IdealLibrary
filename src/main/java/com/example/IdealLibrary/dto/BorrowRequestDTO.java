package com.example.IdealLibrary.dto;

import lombok.Builder;

@Builder
public class BorrowRequestDTO {
    private Long userId;
    private Long bookId;

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
}
