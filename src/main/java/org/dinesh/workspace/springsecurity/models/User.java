package org.dinesh.workspace.springsecurity.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private boolean isEnable;
	private String username;
	private String password;
	@ElementCollection
	private List<String> roles;

	public User() {
	}

	public User(String username) {
		this.username = username;
		this.password = "passme";
		this.roles = Arrays.asList("ROLE_USER");
		this.isEnable = true;
	}

	public User(String username, List<String> roles) {
		this.username = username;
		this.password = "passme";
		this.roles = roles == null ? new ArrayList<String>() : roles;
		this.isEnable = true;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
