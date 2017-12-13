package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/save")
    @ResponseBody
    public Map save(@ModelAttribute("user") User user) {
        return userService.save(user);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
