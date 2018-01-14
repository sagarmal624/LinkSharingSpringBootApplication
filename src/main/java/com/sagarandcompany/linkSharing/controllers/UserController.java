package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.services.ResourceService;
import com.sagarandcompany.linkSharing.services.SubscriptionService;
import com.sagarandcompany.linkSharing.services.TopicService;
import com.sagarandcompany.linkSharing.services.UserService;
import com.sagarandcompany.linkSharing.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;
    @Autowired
    TopicService topicService;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    ResourceService resourceService;

    @RequestMapping("/userUpdate")
    public ModelAndView profile() throws Exception {
        ModelAndView modelAndView = getModalAndView("profile");
        modelAndView.addObject("user", User.getLoginUser());
        return modelAndView;
    }

    @PostMapping("/save")
    @ResponseBody
    public ModelAndView save(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseDTO responseDTO = userService.save(user);
        modelAndView.addObject("user", responseDTO.getData());
        modelAndView.addObject("response", responseDTO);
        modelAndView.setViewName("login");
        return modelAndView;

    }
    /*public ResponseDTO save(@ModelAttribute("user") User user)
    {
        return userService.save(user);
    }
*/

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseDTO getUser(@PathVariable("id") Long id) {
        ResponseDTO responseDTO = userService.findById(id);
        if (responseDTO.getData() == null)
            throw new RecordNotFoundException(LinkSharingKeyword.USER.getValue());
        return responseDTO;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseDTO deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }


    @PostMapping("/update")
    public ModelAndView updateUser(@ModelAttribute("user") User user) throws Exception {
        ResponseDTO responseDTO = userService.updateuser(user);
        ModelAndView modelAndView = getModalAndView("home");
        modelAndView.addObject("user", responseDTO.getData());
        return modelAndView;
    }

}

