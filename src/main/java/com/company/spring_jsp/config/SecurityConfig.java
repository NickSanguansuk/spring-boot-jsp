package com.company.spring_jsp.config;

import com.company.spring_jsp.security.AuthenticationFailureHandlerImpl;
import com.company.spring_jsp.security.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandlerImpl successHandler;

    @Autowired
    private AuthenticationFailureHandlerImpl failureHandler;

    protected void configure(final HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                //.headers()
                //    // frame options implemented in a custom filter
                //    .frameOptions().disable()
                //    .and()
                .authorizeRequests()
                    .antMatchers("/pub/**", "/error/**", "/login/**", "/policies/**", "/search", "/unsubscribe").permitAll()
                    .antMatchers("/admin/**", "/user/**", "/email/**").authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login/login")
                    .loginProcessingUrl("/login/login")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                    .and()
                .logout()
                    .invalidateHttpSession(true)
                    .logoutUrl("/login/logout")
                    .logoutSuccessUrl("/index")
                    .and()
                .rememberMe()
                    .key("SR_KEY")
                    .tokenValiditySeconds(60 * 60 * 24 * 2)
                    .rememberMeParameter("remember-me")
                    .and()
                .exceptionHandling()
                    //.authenticationEntryPoint(getApplicationContext())
                    .accessDeniedPage("/error/404");


    }


}
