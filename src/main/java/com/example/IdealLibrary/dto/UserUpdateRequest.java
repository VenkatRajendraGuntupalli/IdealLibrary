package com.example.IdealLibrary.dto;

import lombok.Builder;

@Builder
public class UserUpdateRequest {
    private String name;
    private String email;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
