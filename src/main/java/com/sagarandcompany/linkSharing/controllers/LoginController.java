package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.LinkResource;
import com.sagarandcompany.linkSharing.services.LoginService;
import com.sagarandcompany.linkSharing.services.ResourceService;
import com.sagarandcompany.linkSharing.services.SubscriptionService;
import com.sagarandcompany.linkSharing.services.TopicService;
import com.sagarandcompany.linkSharing.utility.ResourceVO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import com.sagarandcompany.linkSharing.utility.TopicVO;
import com.sagarandcompany.linkSharing.utility.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController extends BaseController {

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
        ModelAndView modelAndView = null;
        ResponseDTO responseDTO = loginService.validate(username, password, httpSesssion);
        if (responseDTO.getStatus()) {
            modelAndView = getModalAndView("home");
            modelAndView.addObject("unreadResources", resourceService.getResources());

        } else {
            modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            modelAndView.addObject("user", new UserVO());
            modelAndView.addObject("response", responseDTO);
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
