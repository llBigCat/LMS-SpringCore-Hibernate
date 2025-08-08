package com.llbigcat.repository;

import com.llbigcat.dtos.OverDueBorrowingDTO;
import com.llbigcat.entities.Borrowing;

import java.util.List;

public interface IBorrowingRepository {
    boolean save(Borrowing borrowing);
    boolean update(Borrowing borrowing);
    List<Borrowing> findAllOverdueBorrowing();
    List<OverDueBorrowingDTO> findBorrowingsOverdueByDays(int days);
}
