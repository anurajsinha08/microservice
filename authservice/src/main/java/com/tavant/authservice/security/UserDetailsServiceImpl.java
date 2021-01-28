package com.tavant.authservice.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tavant.authservice.model.Register;
import com.tavant.authservice.repository.RegisterRepository;
@Service

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	RegisterRepository registerRepository;
	
	@Override
	@Transactional //Will monitor the transactions which are happening behind the scene
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Register register = registerRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username "+username)
				);
		return RegisterPrincipal.create(register);
	}

}
