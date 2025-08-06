package com.llbigcat;

import com.llbigcat.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.llbigcat.repository")
public class RepositoryConfig {
}
