package com.llbigcat.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title", columnDefinition = "VARCHAR(50)", nullable = false)
    private String title;

    @Column(name="category", columnDefinition = "VARCHAR(50)", nullable = false)
    private String category;

    @Column(name="available", columnDefinition = "BIT DEFAULT 1", nullable = false)
    private Boolean available;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="version")
    private Long version;
}
