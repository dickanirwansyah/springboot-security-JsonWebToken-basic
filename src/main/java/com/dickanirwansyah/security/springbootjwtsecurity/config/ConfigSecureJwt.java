package com.dickanirwansyah.security.springbootjwtsecurity.config;

import com.dickanirwansyah.security.springbootjwtsecurity.security.JwtAuthenticationEntryPoint;
import com.dickanirwansyah.security.springbootjwtsecurity.security.JwtAuthenticationProvider;
import com.dickanirwansyah.security.springbootjwtsecurity.security.JwtAuthenticationTokenFilter;
import com.dickanirwansyah.security.springbootjwtsecurity.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class ConfigSecureJwt extends WebSecurityConfigurerAdapter{

    @Autowired
    private JwtAuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter(){
        JwtAuthenticationTokenFilter tokenFilter = new JwtAuthenticationTokenFilter();
        tokenFilter.setAuthenticationManager(authenticationManager());
        tokenFilter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return tokenFilter;
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{

        http.csrf().disable().authorizeRequests()
                .antMatchers("**/rest/**").authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);

        http.headers();
    }
}
