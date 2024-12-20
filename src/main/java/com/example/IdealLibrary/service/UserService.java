package com.example.IdealLibrary.service;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.dto.BorrowRecordDTO;
import com.example.IdealLibrary.dto.BorrowRequestDTO;
import com.example.IdealLibrary.dto.UserDTO;
import com.example.IdealLibrary.entity.User;
import java.util.List;

public interface UserService {
    List<BookDTO> getAllAvailableBooks();
    void borrowBook(BorrowRequestDTO request);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long userId);
    List<BorrowRecordDTO> getBorrowHistory(Long userId);
}