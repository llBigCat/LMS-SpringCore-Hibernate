package com.llbigcat.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingId {
    @Column(name="book_id", nullable = false)
    private Long bookId;
    @Column(name="member_id", nullable = false)
    private Long memberId;
}
