package com.example.demo.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // السماح بالوصول من https://sign-login-two.vercel.app
        registry.addMapping("/**")
                .allowedOrigins("https://sign-login-two.vercel.app")  // السماح فقط بهذا النطاق
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // السماح بهذه الطرق
                .allowedHeaders("*")  // السماح بجميع الرؤوس
                .allowCredentials(true);  // السماح بالكوكيز إذا لزم الأمر
    }
}
