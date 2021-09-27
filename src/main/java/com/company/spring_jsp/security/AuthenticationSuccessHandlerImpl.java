package com.company.spring_jsp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import antlr.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		System.out.println("########## LOGIN SUCCESS ########## ");

		//// Decide where to send the user based on requested URL
		//SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		//
		//if (savedRequest == null) {
		//	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		//	HttpSession session = attr.getRequest().getSession(true); // true == allow creating
		//	String refererURL = (String) session.getAttribute(LoginRedirectIntercepter.LOGIN_REDIRECT_ATTR);
		//
		//	if (!StringUtils.isEmpty(refererURL)) {
		//		response.sendRedirect(refererURL);
		//	} else {
		//		// Default page redirect
		//		response.sendRedirect(request.getContextPath() + "/user/reminders");
		//	}
		//} else {
		//	response.sendRedirect(savedRequest.getRedirectUrl());
		//}

	}

}
