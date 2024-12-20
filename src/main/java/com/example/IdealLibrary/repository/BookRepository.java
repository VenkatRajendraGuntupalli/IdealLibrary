package com.example.IdealLibrary.repository;

import com.example.IdealLibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.id NOT IN (SELECT br.bookId FROM BorrowRecord br WHERE br.returnDate IS NULL)")
    List<Book> findAllAvailableBooks();
}