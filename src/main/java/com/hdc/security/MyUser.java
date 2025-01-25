package com.hdc.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

public class MyUser extends User {

	private Integer myUserId;

	@SuppressWarnings("deprecation")
	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		System.out.println("in");
		// TODO Auto-generated constructor stub
	}


	public MyUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {

		super(username, password, authorities);
		System.out.println("in");
	}


	public void setUserId(Integer myUserId) {
		this.setMyUserId(myUserId);
	}


	public Integer getMyUserId() {
		return myUserId;
	}


	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}
	

}
