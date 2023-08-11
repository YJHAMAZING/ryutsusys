package com.wetech.ryutsuweb.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MstCorsConfig implements WebMvcConfigurer {
	
	@Value("${cors.allow.origin}")
	private String allowedOrigin;
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                    .allowedOriginPatterns(allowedOrigin)
                    .allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
    }
}