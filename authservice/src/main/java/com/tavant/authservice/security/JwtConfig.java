package com.tavant.authservice.security;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JwtConfig {

	// Based on these values and specifications only our entire tokening work for authorization will be handled
	
	@Value("${security.jwt.uri:/auth/**}")
	private String Uri;
	
	@Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{24*60*60}}") // 24 is hours , 60 is minute, 60 is seconds - We are providing total value in seconds
    private int expiration;

    @Value("${security.jwt.secret:soen6841}") // This secret key is used to provide encryption and decryption for the jwt generated tokens
    private String secret;
    
}
