package com.company.spring_jsp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringJspController {

    @RequestMapping
    public String helloWorld() {
        return "Hello World from Spring Boot - Project spring-jsp";
    }

    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye from Spring Boot - Project spring-jsp";
    }
}
