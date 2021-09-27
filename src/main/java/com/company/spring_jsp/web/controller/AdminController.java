package com.company.spring_jsp.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

}
