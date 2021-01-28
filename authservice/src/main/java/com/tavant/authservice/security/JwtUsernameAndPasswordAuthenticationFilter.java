package com.tavant.authservice.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	// In servlet we have init, service, destroy
	// SImilialry in filter we have life-cycle init, dofilter and destroy
	// Init and destroy will come into the picture only once
	// service and dofilter comes into the picture which is equivalent to number of request done
	
	private AuthenticationManager authenticationManager;
	
	private final JwtConfig jwtConfig;
	
	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager, JwtConfig config) {
		
		this.authenticationManager = authenticationManager;
		jwtConfig = config;
	}
	
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		// Our expectations with this method
		
		try {
			// 1. Get credential from request
			UserCredentials credentials = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);
			
			// 2. Create authentication object which contains credentials which will be used by authentication manager
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
					new UsernamePasswordAuthenticationToken(credentials.getUserName(), 
							credentials.getPassword(), Collections.emptyList());
			
			// 3. AuthManager authenticate the user and UserDetailServiceImpl to load the user details
			return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		// It will give time details in mmilli seconds;
		Long now = System.currentTimeMillis();
		
		String token = Jwts.builder().setSubject(authResult.getName())
				.claim("authorities", authResult.getAuthorities()
						.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now+jwtConfig.getExpiration()*1000))
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret())
				.compact();
		
		// Here we are sending the tokens in terms of response object
		response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix()+token);
		
//		super.successfulAuthentication(request, response, chain, authResult);
	}
	
	// nested class
	public static class UserCredentials {
		
		private String userName;
		private String password;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
}

