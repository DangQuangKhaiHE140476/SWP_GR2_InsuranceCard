package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();	
    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder authenBuilder) throws Exception {
//        authenBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }
	
	
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/login","/changepassword","/home").permitAll()
        .antMatchers(
        		"/admin/showpackagelist",
        		"/showpackage{id}",
        		"/addpackage",
        		"/add",
        		"/editpackage{id}",
        		"/showstafflist",
        		"/showstaffdetail",
        		"/viewaddstaff",
        		"/addstaff",
        		"/viewUpdateStaff{id}",
        		"/updateStaff",
        		"/deleteStaff{id}",
        		"/adminhome",
        		"/showliability",
        		"/viewEditLiability{id}",
        		"/updateLiability",
        		"/viewaddliability",
        		"/addliability")
        	.hasAnyAuthority("ADMIN")
        .antMatchers("/customermenu",
        		"/viewprofile",
        		"/historymenu",
        		"/contractpackagelist",
        		"/showcontractlist",
        		"/paymenthistory",
        		"/accidenthistory",
        		"/punishmenthistory",
        		"/punishmentdetail",
        		"/reportaccident",
        		"/report",
        		"/contractdetail",
        		"/requestcontract",
        		"/contractpackage{id}",
        		"/requestnewcontract{id}",
        		"/checkout",
        		"/request",
        		"/requestcompensation",
        		"/payfine",
        		"/vieweditprofile",
        		"/updateprofile",
        		"/compensationhistory")
        	.hasAnyAuthority("CUSTOMER")
        .antMatchers("/staffmenu",
        		"/showrequestlist",
        		"/requestcancel",
        		"/requestrenew",
        		"/requestnew")
        	.hasAnyAuthority("STAFF")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        	.successHandler(successHandler)        
        	.usernameParameter("username")
        	.passwordParameter("password")
        	.permitAll()
        .and()
        .logout().invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/home").permitAll()
        .and()
        .rememberMe();

       }
}
