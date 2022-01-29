package com.example.blog.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .successForwardUrl("/index")
                .and()
                .csrf()
                .disable();
/*                .and()
                .authorizeRequests()
                .antMatchers("/admin").hasRole("admin")
                .antMatchers("/user").hasRole("user")
                .anyRequest().authenticated()*/;//任何请求都需要认证授权后才能访问
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("123").password("123").roles("admin")
                .and()
                .withUser("yjs").password("yjs").roles("user");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
