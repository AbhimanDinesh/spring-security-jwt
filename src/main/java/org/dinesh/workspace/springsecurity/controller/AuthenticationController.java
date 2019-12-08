package org.dinesh.workspace.springsecurity.controller;

import org.dinesh.workspace.springsecurity.models.AppAuthorizationRequest;
import org.dinesh.workspace.springsecurity.models.AppAuthorizationResponse;
import org.dinesh.workspace.springsecurity.service.AppUserDetailsService;
import org.dinesh.workspace.springsecurity.service.JwtUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AppUserDetailsService userDetailsService;

	@Autowired
	JwtUtilService jwtUtilService;

	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<?> authenticateUser(@RequestBody AppAuthorizationRequest request) throws Exception {
		ResponseEntity<?> response;
		logger.trace("Trying to authenticate user " + request.getUsername());
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			logger.trace("User " + request.getUsername() + "authentication successful.");
			final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
			final String token = jwtUtilService.generateToken(userDetails);
			logger.trace("Jwt: " + token);
			response = ResponseEntity.ok(new AppAuthorizationResponse(token));
		} catch (BadCredentialsException e) {
			logger.error("User " + request.getUsername() + "authentication failed.");
			response = ResponseEntity.status(HttpStatus.PROXY_AUTHENTICATION_REQUIRED)
					.body("User authentiation failed");
		}

		return response;
	}
}
