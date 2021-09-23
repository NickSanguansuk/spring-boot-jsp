package com.company.spring_jsp.web.controller;

import com.company.spring_jsp.web.form.CreateUserForm;
import com.company.spring_jsp.web.form.LoginForm;
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
@RequestMapping("/loginExample")
public class LoginController {

    //@Autowired
    //private UserDao

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ModelAndView createUserGet() {
        System.out.println("Create User page using GET.");

        ModelAndView result = new ModelAndView("login/create-user-jsp");

        result.addObject("form", new CreateUserForm());

        return result;
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ModelAndView createUserPost(@Valid CreateUserForm form, BindingResult bindingResult) throws IOException {
        System.out.println("Create User page using POST.");

        ModelAndView result = new ModelAndView("login/create-user-jsp");

        // Form validation
        result.addObject("form", form);

        System.out.println("form: " + form.toString());

        List<String> errorMessages = new ArrayList<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            System.out.println(error.getField() + " = " + error.getDefaultMessage());
            errorMessages.add(error.getDefaultMessage());
        }

        result.addObject("errorFields", bindingResult.getFieldErrors());
        result.addObject("errorMessages", errorMessages);

        // Additional validation testing here

        // Business logic

        // Save to database next

        // Go to the next page

        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        System.out.println("Login page using GET.");

        ModelAndView result = new ModelAndView("login/login-jsp");

        return result;
    }

    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    //public ModelAndView loginPost(@RequestParam(required = false) String username, @RequestParam(required = false) String password, HttpSession session) throws IOException {
    //    System.out.println("Login page using POST.");
    //
    //    ModelAndView result = new ModelAndView("login/login-jsp");
    //
    //    if ("tom".equals(username) && "jerry".equals(password)) {
    //        System.out.println("username and password are correct.");
    //        session.setAttribute("usernameVariable", username);
    //        result.setViewName("redirect:inbox");
    //    } else {
    //        System.out.println("username and password are incorrect.");
    //        result.addObject("loginMessage", "Password and Username does not match.");
    //    }
    //
    //    return result;
    //}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginPost(LoginForm form, HttpSession session) throws IOException {
        System.out.println("Login page using POST.");

        // Testing HttpSession here
        session.setAttribute("mySecret1", "mySecret1 is 123456");

        //ModelAndView result = new ModelAndView("login/login-jsp");
        ModelAndView result = loginGet();

        if ("tom".equals(form.getUsername()) && "jerry".equals(form.getPassword())) {
            System.out.println("username and password are correct.");
            session.setAttribute("usernameVariable", form.getUsername());
            result.setViewName("redirect:inbox");
        } else {
            System.out.println("username and password are incorrect.");
            result.addObject("loginMessage", "Password and Username does not match.");
        }

        return result;
    }

    @RequestMapping(value = "/inbox", method = RequestMethod.GET)
    public ModelAndView inboxGet(HttpSession session) {
        System.out.println("Inbox page using GET.");

        ModelAndView result = new ModelAndView("login/inbox-jsp");

        if (session.getAttribute("usernameVariable") != null) {
            // user is logged in
            System.out.println("welcomeName is not null.");
            result.addObject("welcomeUsername", session.getAttribute("usernameVariable"));
        } else {
            // user is not logged in
            System.out.println("welcomeName is null.");
            result.setViewName("redirect:login");
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutGet(HttpSession session) {
        System.out.println("Logout page using GET.");

        session.invalidate();
        ModelAndView result = new ModelAndView("redirect:login");
        return result;
    }

}
