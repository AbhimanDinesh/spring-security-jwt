package org.dinesh.workspace.springsecurity.models;

public class AppAuthorizationResponse {

	private final String token;

	public AppAuthorizationResponse(String jwt) {
		this.token = jwt;
	}

	public String getToken() {
		return this.token;
	}

}
