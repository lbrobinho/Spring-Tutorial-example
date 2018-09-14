package com.bo.springdemo.configure;

import com.bo.springdemo.Coach.Coach;
import com.bo.springdemo.Coach.SwimCoach;
import com.bo.springdemo.fortuneService.FortuneService;
import com.bo.springdemo.fortuneService.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.bo.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }


    //define bean for our swim coach and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
