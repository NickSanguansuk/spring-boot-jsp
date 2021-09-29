package com.company.spring_jsp;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJspApplication.class, args);
    }

    //// Testing AWS
    //@Bean
    //ApplicationRunner applicationRunner(AmazonS3 amazonS3) {
    //    return args -> {
    //        amazonS3.listBuckets().forEach(bucket -> System.out.println(bucket.getName()));
    //    };
    //}
}
