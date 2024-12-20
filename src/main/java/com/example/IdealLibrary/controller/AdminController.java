package com.example.IdealLibrary.controller;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.dto.UserDTO;
import com.example.IdealLibrary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/books")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(adminService.addBook(bookDTO));
    }

    @PutMapping("/books")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(adminService.updateBook(bookDTO));
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        adminService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully.");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(adminService.addUser(userDTO));
    }
}