package com.company.spring_jsp.config;

import com.company.spring_jsp.data.dao.UserDao;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import java.sql.Time;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

@Configuration
public class RootConfig {

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {
        // Setting Spring Boot SetTimeZone
        //Log.info("Server TimeZone set to " + TimeZone.getDefault().getDisplayName() + " : " + new Date());
        System.out.println("Server TimeZone now is " + TimeZone.getDefault().getDisplayName() + " : " + new Date());
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Server TimeZone set to " + TimeZone.getDefault().getDisplayName() + " : " + new Date());

        //Map<String, Object> tz = userDao.query
        //System.out.println("Database global timezone = " + tz.get("globaltz") + " : session = " + tz.get("sessiontz") + );
    }

    //@Bean(name = "propertyConfigurer")
    //public static PropertySourcesPlaceholderConfigurer getPropertyPlaceholder() {
    //    return new PropertySourcesPlaceholderConfigurer();
    //}
}
