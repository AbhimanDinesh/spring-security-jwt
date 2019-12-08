package org.dinesh.workspace.springsecurity.service;

import org.springframework.stereotype.Service;

@Service
public class AppService {

	public String greet() {
		return "<h2>Welcome!!!</h2>";
	}

	public String greetUser() {
		return "<h2>Welcome User!!!</h2>";
	}

	public String greetAdmin() {
		return "<h2>Welcome Admin!!!</h2>";
	}
}
