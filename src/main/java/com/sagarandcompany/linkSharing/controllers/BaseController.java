package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.services.ResourceService;
import com.sagarandcompany.linkSharing.services.SubscriptionService;
import com.sagarandcompany.linkSharing.services.TopicService;
import com.sagarandcompany.linkSharing.services.UserService;
import com.sagarandcompany.linkSharing.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
    @Autowired
    UserService userService;
    @Autowired
    TopicService topicService;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    ResourceService resourceService;

    public ModelAndView getModalAndView(String viewName) throws Exception {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("user", User.getLoginUser());
        modelAndView.addObject("response", new ResponseDTO());
        modelAndView.addObject("topics", topicService.getTopicList());
        modelAndView.addObject("trendingTopics", topicService.getTrendingTopicList());
        modelAndView.addObject("subscriptions", subscriptionService.getSubscriptions());
        modelAndView.addObject("resource", new ResourceVO());
        modelAndView.addObject("topic", new TopicVO());
        modelAndView.addObject("visibilities", Visibility.values());
        modelAndView.addObject("seriousnessValues", Seriousness.values());
        if (viewName.equals("home")) {
            modelAndView.addObject("unreadResources", resourceService.getResources());
        }
        return modelAndView;
    }

}
