package com.example.IdealLibrary.controller;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.dto.BorrowRecordDTO;
import com.example.IdealLibrary.dto.BorrowRequestDTO;
import com.example.IdealLibrary.dto.UserDTO;
import com.example.IdealLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/available-books")
    public ResponseEntity<List<BookDTO>> getAvailableBooks() {
        return ResponseEntity.ok(userService.getAllAvailableBooks());
    }

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowRequestDTO request) {
        userService.borrowBook(request);
        return ResponseEntity.ok("Book borrowed successfully.");
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUserDetails(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping("/borrow-history")
    public ResponseEntity<List<BorrowRecordDTO>> getBorrowHistory(@RequestParam Long userId) {
        return ResponseEntity.ok(userService.getBorrowHistory(userId));
    }
}