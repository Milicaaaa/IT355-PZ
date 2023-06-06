package ac.rs.metropolitan.it355pz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    public static final String AUTH_ENDPOINT = "/**";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity, JwtFilter jwtFilter) throws Exception {
        return httpSecurity
                .csrf()
                .disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/games").permitAll()
                .requestMatchers(AUTH_ENDPOINT).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers()
                .cacheControl()
                .and()
                .and().build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Set the allowed origin, or you can specify specific origins
        config.addAllowedMethod(CorsConfiguration.ALL);
        config.addAllowedHeader("*"); // Set the allowed headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
