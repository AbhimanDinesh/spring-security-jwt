package org.dinesh.workspace.springsecurity.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	private boolean isEnabled;

	public AppUserDetails() {
	}

	public AppUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		this.isEnabled = user.isEnable();
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
