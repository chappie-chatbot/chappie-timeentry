package com.chg.hackdays.chappie.chappietimeentry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

/** Created by Nanugonda on 6/22/2018. */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable();
    http.authorizeRequests()
        .antMatchers(
            "/getProviderInfo")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .headers()
        .addHeaderWriter(new StaticHeadersWriter("Application", "Consolidated Invoice"))
        .addHeaderWriter(new StaticHeadersWriter("Copyright", "(C) 2018, CHG Management, Inc."));
  }
}
