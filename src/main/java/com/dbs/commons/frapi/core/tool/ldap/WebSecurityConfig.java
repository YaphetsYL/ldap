package com.dbs.commons.frapi.core.tool.ldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/7 - 03 - 07 - 16:57
 * @Description com.dbs.commons.frapi.core.tool.ldap
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=People")
                //.userDnPatterns("ou=People")
                //.userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=People")
                //.groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:389/dc=maxcrc,dc=com")
                //.url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new Pbkdf2PasswordEncoder())
                .passwordAttribute("userPassword");
    }
}
