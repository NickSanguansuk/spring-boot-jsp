package com.company.spring_jsp.web.controller;

import com.company.spring_jsp.web.form.CreateUser2Form;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadGet(HttpServletRequest request) {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        ModelAndView result = new ModelAndView();
        result.setViewName("file/upload");

        return result;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadPost(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("text") String text) throws IOException {
        System.out.println("Method: " + request.getMethod() + "\t\tURI: " + request.getRequestURI());

        System.out.println("File size = " + file.getSize());
        System.out.println("File name = " + file.getOriginalFilename());
        System.out.println("Text      = " + text);

        String tmpDir = System.getProperty("java.io.tmpdir");
        System.out.println("Temp file path: " + tmpDir);

        File targetFile = new File("e:\\abc\\" + file.getOriginalFilename());

        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);

        ModelAndView result = new ModelAndView();
        result.setViewName("redirect:upload");

        return result;
    }


}
