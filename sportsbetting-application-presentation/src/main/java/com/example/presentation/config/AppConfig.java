package com.example.presentation.config;

import com.example.application.services.SportsBettingApplicationService;
import com.example.application.interfaces.SportsBettingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.example.application.utilities.SportEventFactory;

@Configuration
@ComponentScan("com.example.application")
public class AppConfig {

    @Bean
    public SportEventFactory getSportEventFactory() {
        return new SportEventFactory();
    }

    @Bean
    public SportsBettingService getSportsBettingService() {
        return new SportsBettingApplicationService();
    }
}