package com.llbigcat.main;

import com.llbigcat.AppConfig;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
    }
}
