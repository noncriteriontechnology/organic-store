package com.nctech.organicstore.config;

import com.nctech.organicstore.dto.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.nctech.organicstore.controller",
        "com.nctech.organicstore.service", "com.nctech.organicstore.repository", "com.nctech.organicstore.config"})
public class AppConfig {

}
