package ru.fedorova.vaccination.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registration")
                   .permitAll()
                   .anyRequest().authenticated()
                .and()
                   .formLogin()
                   .loginPage("/login")
                   .permitAll()
                .and()
                   .logout()
                   .logoutSuccessUrl("/login")
                   .permitAll();

    }


 //  @Bean
 //  @Override
 //  public UserDetailsService userDetailsService() {
 //      UserDetails user =
 //              User.withDefaultPasswordEncoder()
 //                      .username("user")
 //                      .password("1111")
 //                      .roles("USER")
 //                      .build();

 //      return new InMemoryUserDetailsManager(user);
 //  }


   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.jdbcAuthentication()
               .dataSource(dataSource)
               .passwordEncoder(NoOpPasswordEncoder.getInstance())
               .usersByUsernameQuery("select name, password, true from user where name=?")
               .authoritiesByUsernameQuery("select name, role from user where name=?");
   }




    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/static/**"); // #3
    }
}
