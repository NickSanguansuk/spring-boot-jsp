package com.company.spring_jsp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/test")
    public String test() {

        return "Hi, this is a simple test.";
    }

    //@RequestMapping(value = "/index", method = RequestMethod.GET)
    //public ModelAndView slashGet() {
    //
    //    ModelAndView result = new ModelAndView("index");
    //
    //    return result;
    //}

    //@RequestMapping(value = "/username/{name}", method = RequestMethod.GET)
    @GetMapping(value = "/username/{name}")
    public ModelAndView slashGet(@PathVariable String name, HttpServletRequest request, HttpSession session) {

        ModelAndView result = new ModelAndView("index");

        result.addObject("name", name);

        System.out.println(name);

        //int x = 1 / 0;

        return result;
    }

    // URL: http://localhost:8080/index/hello?name=Wasin&id=1234
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView indexHello(@RequestParam(required = false) String name,
                                    @RequestParam(required = true) Integer id) {

        ModelAndView result = new ModelAndView("index");

        result.addObject("name", name);
        result.addObject("id", id);

        System.out.println("hello " + name + " id = " + id);

        return result;
    }

    // URL: http://localhost:8080/index/submit?name=Wasin&id=1234
    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public ModelAndView indexSubmit(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) Integer id) {

        ModelAndView result = new ModelAndView("index");

        result.addObject("name", name);
        result.addObject("id", id);

        System.out.println("hello " + name + " id = " + id);

        return result;
    }

}
