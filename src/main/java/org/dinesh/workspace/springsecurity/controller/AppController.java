package org.dinesh.workspace.springsecurity.controller;

import org.dinesh.workspace.springsecurity.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	AppService service;

	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public String welcomeUser() {
		return service.greetUser();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	public String welcomeAdmin() {
		return service.greetAdmin();
	}

}
