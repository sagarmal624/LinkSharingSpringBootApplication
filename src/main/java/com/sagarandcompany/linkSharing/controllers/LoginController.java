package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.services.LoginService;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/validate")
    @ResponseBody
    public ResponseDTO validate(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSesssion) {
        return loginService.validate(username, password, httpSesssion);
    }

    @GetMapping("/logout")
    @ResponseBody
    public ResponseDTO logout(HttpSession httpSesssion) {
        return loginService.logout(httpSesssion);
    }

}
