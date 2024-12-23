package com.example.IdealLibrary.service;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.dto.UserDTO;

import java.util.List;

public interface AdminService {
    BookDTO addBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(Long bookId);
    List<UserDTO> getAllUsers();
    UserDTO addUser(UserDTO userDTO);
}
