package com.bo.springdemo.config;

import com.bo.springdemo.coach.Coach;
import com.bo.springdemo.coach.WrestlingCoach;
import com.bo.springdemo.fortuneService.FortuneService;
import com.bo.springdemo.fortuneService.HappyFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    public FortuneService happyFortuneService() {
        return new HappyFortuneService();
    }

    @Bean
    public Coach wrestlingCoach() {

        return new WrestlingCoach(happyFortuneService());
    }
}
