package com.company.spring_jsp.web.controller;

import com.company.spring_jsp.data.dao.UserDao;
import com.company.spring_jsp.data.entity.User;
import com.company.spring_jsp.web.form.CreateUser2Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login2")
public class Login2Controller {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ModelAndView createUserGet() {
        System.out.println("Create User 2 page using GET.");

        ModelAndView result = new ModelAndView("login2/create-user-2-jsp");

        result.addObject("form", new CreateUser2Form());

        return result;
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ModelAndView createUserPost(@Valid CreateUser2Form form, BindingResult bindingResult, HttpSession session) throws IOException {
        System.out.println("Create User 2 page using POST.");

        ModelAndView result = new ModelAndView("login2/create-user-2-jsp");
        //ModelAndView result = createUserGet();

        // Form validation
        result.addObject("form", form);

        System.out.println("form: " + form.toString());

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + " = " + error.getDefaultMessage());
                errorMessages.add(error.getDefaultMessage());
            }

            result.addObject("errorFields", bindingResult.getFieldErrors());
            result.addObject("errorMessages", errorMessages);

            return result;
        }

        // Business logic
        User user = new User();

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setPhone(form.getPhone());
        user.setAddress(form.getAddress());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setZipCode(form.getZipCode());

        System.out.println(user);

        userDao.save(user); // This line is magic

        System.out.println("Added new User to the Database.");

        // Save to database next

        // Go to the next page
        session.setAttribute("userInfo", user);
        result.setViewName("redirect:inbox");

        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        System.out.println("Login 2 page using GET.");

        ModelAndView result = new ModelAndView("login2/login-2-jsp");

        return result;
    }

    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    //public ModelAndView loginPost(LoginForm form, HttpSession session) throws IOException {
    //    System.out.println("Login 2 page using POST.");
    //
    //    // Testing HttpSession here
    //    session.setAttribute("mySecret1", "mySecret1 is 123456");
    //
    //    //ModelAndView result = new ModelAndView("login/login-jsp");
    //    ModelAndView result = loginGet();
    //
    //    if ("tom".equals(form.getUsername()) && "jerry".equals(form.getPassword())) {
    //        System.out.println("username and password are correct.");
    //        session.setAttribute("usernameVariable", form.getUsername());
    //        result.setViewName("redirect:inbox");
    //    } else {
    //        System.out.println("username and password are incorrect.");
    //        result.addObject("loginMessage", "Password and Username does not match.");
    //    }
    //
    //    return result;
    //}

    @RequestMapping(value = "/inbox", method = RequestMethod.GET)
    public ModelAndView inboxGet(HttpSession session) {
        System.out.println("Inbox 2 page using GET.");

        ModelAndView result = new ModelAndView("login2/inbox-2-jsp");

        if (session.getAttribute("userInfo") != null) {
            // user is logged in
            System.out.println("userInfo is not null.");
            User user = (User)session.getAttribute("userInfo");
            String messageStr = user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")";
            result.addObject("welcomeUserMessage", messageStr);
        } else {
            // user is not logged in
            System.out.println("userInfo is null.");
            result.setViewName("redirect:login");
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutGet(HttpSession session) {
        System.out.println("Logout 2 page using GET.");

        session.invalidate();
        ModelAndView result = new ModelAndView("redirect:login");
        return result;
    }

}
