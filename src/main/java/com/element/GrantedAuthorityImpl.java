package com.element;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
	
	private String role;
	
	
	@Override
	public String getAuthority() {
		
		return null;
	}


	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
