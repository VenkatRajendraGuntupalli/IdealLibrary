package com.example.IdealLibrary.service;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.entity.Book;
import java.util.List;
public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long bookId);
    BookDTO addBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(Long bookId);
}
