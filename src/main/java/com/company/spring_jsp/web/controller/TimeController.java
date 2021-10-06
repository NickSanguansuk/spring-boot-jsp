package com.company.spring_jsp.web.controller;

import com.company.spring_jsp.web.form.TimeFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/time")
public class TimeController {

    @RequestMapping(value = "/time")
    public ModelAndView time() {
        ModelAndView result = new ModelAndView();
        result.setViewName("time/time");
        return result;
    }

    @RequestMapping(value = "/timeSubmit")
    public ModelAndView timeSubmit(TimeFormBean form) throws ParseException {
        ModelAndView result = new ModelAndView();
        result.setViewName("time/time");

        System.out.println("---> " + form.getFullDate());
        System.out.println("---> " + form.getStartTime());
        System.out.println("---> " + form.getEndTime());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTimeStart = dateFormat.parse(form.getFullDate() + " " + form.getStartTime());
        Date dateTimeEnd = dateFormat.parse(form.getFullDate() + " " + form.getEndTime());

        System.out.println("---> " + dateTimeStart);
        System.out.println("---> " + dateTimeEnd);

        return result;
    }

}
