package com.llbigcat.main;

import com.llbigcat.AppConfig;
import com.llbigcat.repository.IBookRepository;
import com.llbigcat.repository.IBorrowingRepository;
import com.llbigcat.repository.IMemberRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IBorrowingRepository borrowingRepository = context.getBean(IBorrowingRepository.class);
        System.out.println(borrowingRepository.findBorrowingsOverdueByDays(1).size());
    }
}
