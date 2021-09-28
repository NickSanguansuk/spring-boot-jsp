package com.company.spring_jsp.web.controller;

import com.company.spring_jsp.data.dao.UserDao;
import com.company.spring_jsp.data.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("")
    public ModelAndView searchGetOrPost(HttpServletRequest request, @RequestParam(required = false) String searchText) {
        System.out.println("URI: " + request.getRequestURI() + "\tMethod: " + request.getMethod());

        //// Testing
        //System.out.println(request.getRequestURL());
        //System.out.println(request.getRequestURI());
        //System.out.println(request.getMethod());

        ModelAndView result = new ModelAndView();
        result.setViewName("search/search-jsp");

        List<User> users = new ArrayList<>();

        if (!StringUtils.isEmpty(searchText)) {
            users = userDao.findUsersByEmailContains(searchText);
        }

        result.addObject("users", users);
        result.addObject("searchText", searchText);

        return result;
    }

    @RequestMapping("/detail")
    public ModelAndView detailGetOrPost(HttpServletRequest request, @RequestParam(required = true) Integer id) throws Exception {
        System.out.println("URI: " + request.getRequestURI() + "\tMethod: " + request.getMethod());

        ModelAndView result = new ModelAndView();
        result.setViewName("search/detail-jsp");

        User user = userDao.findUserById(id);
        if (user == null) {
            throw new Exception("User ID " + id + " does not exist.");
        }

        result.addObject("user", user);

        return result;
    }


}
