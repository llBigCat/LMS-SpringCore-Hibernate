package com.llbigcat;

import com.llbigcat.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.llbigcat.repository")
public class RepositoryConfig {
    @Bean
    public IAuthorRepository authorRepository() {
        return new AuthorRepository();
    }

    @Bean
    public IBookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public IMemberRepository memberRepository() {
        return new MemberRepository();
    }

    @Bean
    public IBorrowingRepository borrowingRepository() {
        return new BorrowingRepository();
    }
}
