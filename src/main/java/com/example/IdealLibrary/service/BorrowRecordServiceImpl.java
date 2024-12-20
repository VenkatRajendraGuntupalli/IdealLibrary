package com.example.IdealLibrary.service;


import com.example.IdealLibrary.dto.BorrowRecordDTO;
import com.example.IdealLibrary.entity.Book;
import com.example.IdealLibrary.entity.BorrowRecord;
import com.example.IdealLibrary.exception.ResourceNotFoundException;
import com.example.IdealLibrary.repository.BookRepository;
import com.example.IdealLibrary.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRepository;

    @Override
    public List<BorrowRecordDTO> getAllBorrowRecords() {
        List<BorrowRecord> records = borrowRepository.findAll();
        return records.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public BorrowRecordDTO addBorrowRecord(BorrowRecordDTO recordDTO) {
        BorrowRecord record = new BorrowRecord();
        record.setUserId(recordDTO.getUserId());
        record.setBookId(recordDTO.getBookId());
        record.setBorrowDate(recordDTO.getBorrowDate());
        record.setReturnDate(recordDTO.getReturnDate());
        record.setBookPrice(recordDTO.getBookPrice());
        record = borrowRepository.save(record);
        return convertToDTO(record);
    }

    @Override
    public void updateReturnDate(Long recordId, LocalDate returnDate) {
        BorrowRecord record = borrowRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found"));
        record.setReturnDate(returnDate);
        borrowRepository.save(record);
    }

    private BorrowRecordDTO convertToDTO(BorrowRecord record) {
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
