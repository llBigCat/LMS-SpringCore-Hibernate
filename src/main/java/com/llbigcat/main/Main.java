package com.llbigcat.main;

import com.llbigcat.AppConfig;
import com.llbigcat.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IBookRepository bookRepository = context.getBean(IBookRepository.class);
        System.out.println("Listing all books:");
        bookRepository.findAll().forEach(System.out::println);
    }
}
