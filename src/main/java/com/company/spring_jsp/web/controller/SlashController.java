package com.company.spring_jsp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SlashController {

    @RequestMapping(value = { "/", "/index", "/index.html" })
    public ModelAndView slash(HttpServletRequest request) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        ModelAndView response = new ModelAndView();
        response.setViewName("index");

        return response;
    }
}
