package com.llbigcat.main;

import com.llbigcat.AppConfig;
import com.llbigcat.repository.IBookRepository;
import com.llbigcat.repository.IMemberRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IBookRepository bookRepository = context.getBean(IBookRepository.class);
        bookRepository.topBorrowedBooks(5).forEach(System.out::println);
        bookRepository.findAll().forEach(System.out::println);
        IMemberRepository memberRepository = context.getBean(IMemberRepository.class);
        System.out.println(memberRepository.canBorrowMoreBooks(1L));
    }
}
