package com.bo.jackson.json.demo.config;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bo.jackson.json.demo")
public class DemoAppConfig {
}
