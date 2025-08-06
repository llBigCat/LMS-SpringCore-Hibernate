package com.llbigcat.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name="email", nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name="phone", nullable = false, columnDefinition = "CHAR(15)")
    private String phone;

    @Column(name="version", nullable = false)
    private Integer version;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<Borrowing> borrowings;
}
