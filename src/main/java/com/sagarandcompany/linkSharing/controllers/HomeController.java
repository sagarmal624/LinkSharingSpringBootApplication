package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import com.sagarandcompany.linkSharing.utility.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController extends BaseController {
    @RequestMapping("/")
    public ModelAndView landingPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("user", new UserVO());
        modelAndView.addObject("response", new ResponseDTO());
        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView home() throws Exception {
        ModelAndView modelAndView = getModalAndView("home");
        return modelAndView;
    }
}
