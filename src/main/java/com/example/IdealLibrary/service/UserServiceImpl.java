package com.example.IdealLibrary.service;

import com.example.IdealLibrary.dto.BookDTO;
import com.example.IdealLibrary.dto.BorrowRecordDTO;
import com.example.IdealLibrary.dto.BorrowRequestDTO;
import com.example.IdealLibrary.dto.UserDTO;
import com.example.IdealLibrary.entity.Book;
import com.example.IdealLibrary.entity.BorrowRecord;
import com.example.IdealLibrary.entity.User;
import com.example.IdealLibrary.exception.ResourceNotFoundException;
import com.example.IdealLibrary.repository.BookRepository;
import com.example.IdealLibrary.repository.BorrowRecordRepository;
import com.example.IdealLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BookDTO> getAllAvailableBooks() {
        List<Book> books = bookRepository.findAllAvailableBooks();
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void borrowBook(BorrowRequestDTO request) {
        BorrowRecord record = new BorrowRecord();
        record.setUserId(request.getUserId());
        record.setBookId(request.getBookId());
        record.setBorrowDate(LocalDate.now());
        borrowRepository.save(record);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<BorrowRecordDTO> getBorrowHistory(Long userId) {
        List<BorrowRecord> records = borrowRepository.findByUserId(userId);
        return records.stream().map(this::convertToBorrowRecordDTO).collect(Collectors.toList());
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



    private BorrowRecordDTO convertToBorrowRecordDTO(BorrowRecord record) {
        return new BorrowRecordDTO(
                record.getId(),
                record.getUserId(),
                record.getBookId(),
                record.getBorrowDate(),
                record.getReturnDate(),
                record.getBookPrice()
        );
    }

}
