package com.sagarandcompany.linkSharing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Link Sharing application  is a web based application";
    }
}
