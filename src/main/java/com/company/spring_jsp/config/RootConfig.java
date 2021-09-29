package com.company.spring_jsp.config;

import com.company.spring_jsp.data.dao.UserDao;
import com.company.spring_jsp.data.entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.PostConstruct;
import java.sql.Time;
import java.text.SimpleDateFormat;
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

        //Map<String, Object> tz = userDao.queryTimezone();
        //System.out.println("Database global timezone = " + tz.get("globaltz") + " : session = " + tz.get("sessiontz") + " : now = " + tz.get("now"));

        //User user = userDao.findUserById(1);
        //System.out.println("User Create Date = " + user.getCreateDate());
        //SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        //outputFormat.setTimeZone(TimeZone.getTimeZone("CST"));
        //System.out.println(outputFormat.format(user.getCreateDate()));
    }

    //@Bean(name = "propertyConfigurer")
    //public static PropertySourcesPlaceholderConfigurer getPropertyPlaceholder() {
    //    return new PropertySourcesPlaceholderConfigurer();
    //}

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        multipartResolver.setPreserveFilename(true);
        return multipartResolver;
    }

}
