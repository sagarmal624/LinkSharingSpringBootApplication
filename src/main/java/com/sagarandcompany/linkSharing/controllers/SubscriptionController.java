package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/save")
    @ResponseBody
    public Map save(@ModelAttribute("subscrptn") Subscription subscrptn)
    {
        return  subscriptionService.save(subscrptn);

    }


}
