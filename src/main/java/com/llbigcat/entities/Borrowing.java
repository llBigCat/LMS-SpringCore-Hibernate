package com.llbigcat.entities;

import com.llbigcat.dtos.OverDueBorrowingDTO;
import com.llbigcat.entities.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="borrowing")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SqlResultSetMapping(
        name = "OverDueBorrowingMapping",
        classes = @ConstructorResult(
                targetClass = OverDueBorrowingDTO.class,
                columns = {
                        @ColumnResult(name = "borrowDate", type = LocalDateTime.class),
                        @ColumnResult(name = "dueDate", type = LocalDateTime.class),
                        @ColumnResult(name = "memberId", type = Long.class),
                        @ColumnResult(name = "memberName", type = String.class),
                        @ColumnResult(name = "memberEmail", type = String.class),
                        @ColumnResult(name = "memberPhone", type = String.class),
                        @ColumnResult(name = "bookId", type = Long.class),
                        @ColumnResult(name = "bookTitle", type = String.class),
                        @ColumnResult(name = "bookCategory", type = String.class)
                }
        )
)
public class Borrowing {
    @EmbeddedId
    private BorrowingId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "book_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")
    @JoinColumn(name = "member_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Member member;

    @Column(name="borrow_date", nullable = false)
    private LocalDateTime borrowDate;

    @Column(name="return_date")
    private LocalDateTime returnDate;

    @Column(name="due_date", nullable = false)
    private LocalDateTime dueDate;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private Integer version;
}
