package org.dinesh.workspace.springsecurity.models;

public class AppAuthorizationRequest {

	private String username;
	private String password;

	public AppAuthorizationRequest() {
	}

	public AppAuthorizationRequest(String username, String password) {
		this.username = username;
		this.password = password;
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

}
