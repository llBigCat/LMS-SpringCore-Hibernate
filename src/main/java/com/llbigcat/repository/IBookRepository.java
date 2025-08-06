package com.llbigcat.repository;

import com.llbigcat.entities.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IBookRepository {
    Optional<Book> findById(Long id);
    List<Book> findAll();
    boolean create(Book book);
    boolean update(Book book);
    boolean delete(Book book);
    List<Book> search(Map<String, Object> params);
}
