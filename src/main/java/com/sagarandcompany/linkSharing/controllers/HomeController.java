package com.sagarandcompany.linkSharing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Wel-come to Link Sharing application  .... created by Indu Mukhi";
    }
}
