package com.tavant.authservice.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tavant.authservice.model.Register;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class RegisterPrincipal implements UserDetails {

	private long id;
	private String firstName;
	private String lastName;
	private String userName;
	// Whatever the response will go we don't want email and password in that so we mark json ignore in that,
	// Because in token email and password is not required as they are security concern things
	@JsonIgnore
	private String email;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public static RegisterPrincipal create(Register register) {
		
		// By default user role will be added
		// We cal also add / provide any other role
		List<GrantedAuthority> authorities = register.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		return new RegisterPrincipal(register.getId(), register.getFirstName(), register.getLastName(), 
				register.getUsername(), register.getEmail(), 
				register.getPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object o) {
		
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		RegisterPrincipal that = (RegisterPrincipal) o;
		return Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id);
	}
	
}
