package com.llbigcat.repository;

import com.llbigcat.entities.Borrowing;

public interface IBorrowingRepository {
    boolean save(Borrowing borrowing);
    boolean update(Borrowing borrowing);
}
