package com.company.spring_jsp.web.controller;

import com.company.spring_jsp.data.dao.UserDao;
import com.company.spring_jsp.data.entity.User;
import com.company.spring_jsp.web.form.CreateUser2Form;
import com.company.spring_jsp.web.form.CreateUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public User getUserById(@PathVariable Integer id) {
        User user = userDao.findUserById(id);
        return  user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User user = userDao.findUserById(id);
        return  user;
    }



}
