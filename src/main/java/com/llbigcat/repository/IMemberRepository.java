package com.llbigcat.repository;

import com.llbigcat.entities.Member;

import java.util.Optional;

public interface IMemberRepository {
    boolean create(Member member);
    boolean update(Member member);
    boolean delete(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByName(String name);
    Optional<Member> findByPhone(String phone);
    boolean canBorrowMoreBooks(Long memberId);
}
