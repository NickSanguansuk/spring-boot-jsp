package com.company.spring_jsp.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileEmptyImpl implements ConstraintValidator<MultipartFileEmpty, MultipartFile> {

    public static final Logger LOG = LoggerFactory.getLogger(MultipartFileEmptyImpl.class);

    @Override
    public void initialize(MultipartFileEmpty constraintAnnotation) {

    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        String filename = value.getOriginalFilename();

        if (!StringUtils.isEmpty(filename)) {
            return true;
        }

        return false;
    }

}
