package com.company.spring_jsp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SlashController {

    @RequestMapping(value = { "/", "/index", "/index.html" })
    public ModelAndView slash() {
        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        return response;
    }
}
