package org.scopeindia.ecomm.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration config = new CorsConfiguration();

    // IMPORTANT: frontend ELB origin (no trailing slash)
    config.setAllowedOrigins(List.of(
      "http://a31e60a343e9f4c22a7d6dfdd7099d38-1715227186.ap-south-1.elb.amazonaws.com"
    ));

    config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
    config.setAllowedHeaders(List.of("*"));
    config.setExposedHeaders(List.of("Location"));
    config.setAllowCredentials(false); // keep false unless you use cookies/auth

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    return new CorsFilter(source);
  }
}
