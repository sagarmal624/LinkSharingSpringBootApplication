package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/validate")
    @ResponseBody
    public Map validate(@RequestParam("username") String username, @RequestParam("password") String password) {
        return loginService.validate(username, password);

    }


}
