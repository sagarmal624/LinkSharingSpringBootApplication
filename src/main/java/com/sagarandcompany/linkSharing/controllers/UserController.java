package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody()
    public User getUser(@ModelAttribute("") User user) {

        return user;
    }
}
