package com.dddca.masterdatamanager.infrastructure.springsecurity;


import com.dddca.masterdatamanager.infrastructure.jwtauth.JwtAuthenticationFilter;
import com.dddca.masterdatamanager.infrastructure.jwtauth.JwtAuthorizationFilter;
import com.dddca.masterdatamanager.infrastructure.jwtauth.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final JwtUtil jwtUtil;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService,
                             JwtAuthorizationFilter jwtAuthorizationFilter, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        // 1. AuthenticationManagerをビルド
        // TODO : AuthenticationManager Bean を独立させる、
        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        AuthenticationManager authenticationManager = authManagerBuilder.build();

        http

                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .loginPage("/login")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/login?error")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login"))
                .authorizeRequests(auth -> auth
                        // staticリソースのアクセス許可, 例:/css/**, /js/**, /images/**など
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // public インタフェースAPI用
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager)
                .addFilter(new JwtAuthenticationFilter(authenticationManager, jwtUtil))
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.maximumSessions(1).maxSessionsPreventsLogin(true));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
