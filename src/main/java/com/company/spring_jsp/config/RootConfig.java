package com.company.spring_jsp.config;

import com.company.spring_jsp.data.dao.UserDao;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class RootConfig {

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {
        // Setting Spring Boot SetTimeZone
        //Log.info("Server TimeZone set to " + TimeZone.getDefault().getDisplayName() + " : " + new Date());
        System.out.println("Server TimeZone set to " + TimeZone.getDefault().getDisplayName() + " : " + new Date());

    }
}
