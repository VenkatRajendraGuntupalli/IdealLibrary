package com.example.IdealLibrary.service;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.entity.Book;
import com.example.IdealLibrary.exception.ResourceNotFoundException;
import com.example.IdealLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        return convertToDTO(book);
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookRepository.findById(bookDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishDate(bookDTO.getPublishDate());
        book.setPrice(bookDTO.getPrice());
        book.setType(bookDTO.getType());
        book.setSuitableForAges(bookDTO.getSuitableForAges());
        book.setGenre(bookDTO.getGenre());
        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    private BookDTO convertToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getPublishDate(),
                book.getPrice(),
                book.getType(),
                book.getSuitableForAges(),
                book.getGenre()
        );
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishDate(bookDTO.getPublishDate());
        book.setPrice(bookDTO.getPrice());
        book.setType(bookDTO.getType());
        book.setSuitableForAges(bookDTO.getSuitableForAges());
        book.setGenre(bookDTO.getGenre());
        return book;
    }
}
