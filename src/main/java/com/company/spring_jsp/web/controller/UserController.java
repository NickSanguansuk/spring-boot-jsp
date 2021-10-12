package com.company.spring_jsp.web.controller;

import com.company.spring_jsp.data.dao.UserDao;
import com.company.spring_jsp.data.entity.User;
import com.company.spring_jsp.web.form.CreateUser2Form;
import com.company.spring_jsp.web.form.CreateUserForm;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // URL: "http://localhost:8080/user/3"
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(HttpServletRequest request, @PathVariable Integer id) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        User user = userDao.findUserById(id);
        return user;
    }

    // URL: "http://localhost:8080/user/?email=wasin.sanguansuk%40outlook.com"
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByEmail(HttpServletRequest request, @RequestParam String email) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        User user = userDao.findUserByEmail(email);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(HttpServletRequest request, @RequestBody(required = true) @Valid CreateUser2Form form, BindingResult bindingResult, HttpSession session) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        System.out.println("---> form: " + form.toString());

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + " = " + error.getDefaultMessage());
                errorMessages.add(error.getDefaultMessage());
            }

            String json = new Gson().toJson(errorMessages);
            return json;
        }

        // business logic
        User user = new User();

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        //user.setPassword(form.getPassword());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setPhone(form.getPhone());
        user.setAddress(form.getAddress());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setZipCode(form.getZipCode());

        System.out.println("---> user: " + user);

        userDao.save(user);

        System.out.println("---> Added new User to the Database.");

        // Go to the next page

        String json = new Gson().toJson(user);
        return json;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(HttpServletRequest request, @RequestBody(required = true) @Valid CreateUser2Form form, BindingResult bindingResult) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        // Do your error checking

        User user = userDao.findUserById(form.getId());

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        //user.setPassword(form.getPassword());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setPhone(form.getPhone());
        user.setAddress(form.getAddress());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setZipCode(form.getZipCode());

        System.out.println("---> user: " + user);

        userDao.save(user);

        System.out.println("---> Updated User in the Database.");

        String json = new Gson().toJson(user);
        return json;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(HttpServletRequest request, @PathVariable Integer id) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        User user = userDao.findUserById(id);
        userDao.delete(user);

        return "{\"status\",\"ok\"}";
    }

}
