//package com.company.spring_jsp.web.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import com.company.spring_jsp.data.entity.User;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.seriesreminder.security.AuthenticatedUserService;
//
//public class CurrentPasswordValidImpl implements ConstraintValidator<CurrentPasswordValid, String> {
//
//	public static final Logger LOG = LoggerFactory.getLogger(CurrentPasswordValidImpl.class);
//
//	@Autowired
//	private AuthenticatedUserService authenticatedUserService;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public void initialize(CurrentPasswordValid constraintAnnotation) {
//
//	}
//
//	@Override
//	public boolean isValid(String value, ConstraintValidatorContext context) {
//		if (StringUtils.isEmpty(value)) {
//			return true;
//		}
//
//		User user = authenticatedUserService.getCurrentUser();
//
//		return passwordEncoder.matches(value, user.getPassword());
//	}
//
//}
