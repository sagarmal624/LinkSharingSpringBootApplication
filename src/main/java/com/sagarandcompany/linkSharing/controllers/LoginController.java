package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.LinkResource;
import com.sagarandcompany.linkSharing.services.LoginService;
import com.sagarandcompany.linkSharing.services.ResourceService;
import com.sagarandcompany.linkSharing.services.SubscriptionService;
import com.sagarandcompany.linkSharing.services.TopicService;
import com.sagarandcompany.linkSharing.utility.ResourceVO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import com.sagarandcompany.linkSharing.utility.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    TopicService topicService;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    ResourceService resourceService;

    @PostMapping("/validate")
    @ResponseBody
    public ModelAndView validate(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSesssion) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        ResponseDTO responseDTO = loginService.validate(username, password, httpSesssion);
        if (responseDTO.getStatus()) {

            modelAndView.addObject("topics", topicService.getTopicList());
//            modelAndView.addObject("sunscriptions", subscriptionService.getSubscriptions());
            modelAndView.addObject("unreadResources", resourceService.getResources());
            modelAndView.addObject("resource", new ResourceVO());
            modelAndView.addObject("response", new ResponseDTO());
            modelAndView.addObject("username", responseDTO.getData());
            modelAndView.addObject("topic", new TopicVO());
            modelAndView.setViewName("home");
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("error", true);
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSesssion) {
        ResponseDTO responseDTO = loginService.logout(httpSesssion);
        if (responseDTO.getStatus())
            return "redirect:/";
        else
            return "";
    }

}
