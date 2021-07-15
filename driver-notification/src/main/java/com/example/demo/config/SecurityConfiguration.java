package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filter.JwtFilter;
import com.example.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
	private JwtFilter jwtFilter;

    @Autowired
    private UserService userService;
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    	auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance();
    }
    
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		
		 
		 
		  http.csrf().disable()
			.authorizeRequests().antMatchers("/authenticate").permitAll()
			.antMatchers("/DriverLogin.html").permitAll()
			.anyRequest().
			 authenticated()
			 .and()
				.logout().logoutUrl("/logout")
				//back to login page
				.logoutSuccessUrl("/DriverLogin.html")
				//delete jwt token after logout
				.invalidateHttpSession(true)
				.clearAuthentication(true);
			 
        
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/Fonts/**");
    }
}