package com.llbigcat.main;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
    }
}
