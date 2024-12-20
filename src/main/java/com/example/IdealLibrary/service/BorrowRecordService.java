package com.example.IdealLibrary.service;

import com.example.IdealLibrary.dto.BorrowRecordDTO;

import java.time.LocalDate;
import java.util.List;

public interface BorrowRecordService {
    List<BorrowRecordDTO> getAllBorrowRecords();
    BorrowRecordDTO addBorrowRecord(BorrowRecordDTO recordDTO);
    void updateReturnDate(Long recordId, LocalDate returnDate);
}
