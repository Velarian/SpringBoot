package com.PWS.MongoDB.SpringbootMongoDB.CONFIG;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired          
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // TODO Auto-generated method stub
//        http
//            .csrf().disable()
//            .authorizeRequests().antMatchers("/login").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login").permitAll()
//            .and()
//            .logout().invalidateHttpSession(true)
//            .clearAuthentication(true)
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .logoutSuccessUrl("/logout-success").permitAll();
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        // TODO Auto-generated method stub
//        List<UserDetails> users=new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder().username("Pranav").password("1234").roles("USER").build());
//        
//        users.add(User.withDefaultPasswordEncoder().username("Sharma").password("1234").roles("USER").build());
//        return new InMemoryUserDetailsManager(users);
//
//    }
    
    

}
