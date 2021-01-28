package com.tavant.authservice.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tavant.authservice.security.JwtConfig;
import com.tavant.authservice.security.JwtUsernameAndPasswordAuthenticationFilter;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// To refer a particular bean we used @Qualifier annotation
	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			//Make sure we use stateless session; session wont be used to store user's state
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			//Handle an unauthorized attempts
			.exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
			.and()
			// Add a filter to validate user credentials and add token in the response header
			
			//What's the authenticationManager() ?
			// An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
			// The filter needs this auth manager to authenticate the user.
			.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
			.authorizeRequests()
			// Allow all post request
			.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
			.antMatchers(HttpMethod.POST, "/api/auth/register/signup/**").permitAll()
			// Index is accessible
			.antMatchers(HttpMethod.GET, "/**").permitAll()
			// any other request must be authenticated
			.anyRequest().authenticated();
		
	}
	
	// Spring has UserDetailsService Interface, which can be overridden to provide our implementation for fetching user from database (or any other source)
	// The UserDetailService object is used by the auth manager to load the user from database
	// In addition, we need to define the password encoder also. So auth manager can compare and verify passwords.
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}
	
	@Bean
	// To encrypt the password
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
