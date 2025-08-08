package com.llbigcat.dtos;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OverDueBorrowingDTO {
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private Long memberId;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private Long bookId;
    private String bookTitle;
    private String bookCategory;
}
