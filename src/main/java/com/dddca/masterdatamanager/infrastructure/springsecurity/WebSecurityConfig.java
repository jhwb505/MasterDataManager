package com.dddca.masterdatamanager.infrastructure.springsecurity;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

/*        http

                .formLogin(form -> form
                        //.loginProcessingUrl("/login")
                        .loginPage("/login").permitAll()
                        //.defaultSuccessUrl("/").permitAll()
                        .failureUrl("/login?error")
                ).authorizeRequests(auth -> auth.requestMatchers("/public/**").permitAll());*/

/*        http

                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/").permitAll()
                        .failureUrl("/login?error")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login"))
                .authorizeRequests(auth -> auth
                        // staticリソースのアクセス許可, 例:/css/**, /js/**, /images/**など
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/login").permitAll()
                        // public インタフェースAPI用
                        .requestMatchers("/public/**").permitAll()
                )
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.maximumSessions(1).maxSessionsPreventsLogin(true));*/
/*        http

                .authorizeRequests(auth -> auth
                        // staticリソースのアクセス許可, 例:/css/**, /js/**, /images/**など

                        // public インタフェースAPI用

                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated());*/
        http
                .authorizeRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login").permitAll());

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
