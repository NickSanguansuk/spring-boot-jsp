package com.company.spring_jsp.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	//public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
		System.out.println("########## LOGIN FAILURE ##########" + exception.getMessage());

		//LOG.info(exception.getMessage());
		//
		//if (exception instanceof DisabledException) {
		//	response.sendRedirect("/login/login?disabled");
		//} else {
		//	response.sendRedirect("/login/login?error=true");
		//}
	}

}
