package com.example.IdealLibrary.service;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.dto.UserDTO;
import com.example.IdealLibrary.entity.Book;
import com.example.IdealLibrary.entity.User;
import com.example.IdealLibrary.exception.ResourceNotFoundException;
import com.example.IdealLibrary.repository.BookRepository;
import com.example.IdealLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishDate(bookDTO.getPublishDate());
        book.setPrice(bookDTO.getPrice());
        book.setType(bookDTO.getType());
        book.setSuitableForAges(bookDTO.getSuitableForAges());
        book.setGenre(bookDTO.getGenre());
        bookRepository.save(book);
        return bookDTO;
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
        bookRepository.save(book);
        return bookDTO;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }


    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;
    }
}





