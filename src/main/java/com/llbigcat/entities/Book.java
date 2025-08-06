package com.llbigcat.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Column(name="version", nullable = false)
    private Integer version;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Borrowing> borrowings;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
}
