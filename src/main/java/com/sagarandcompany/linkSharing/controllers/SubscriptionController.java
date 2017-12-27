package com.sagarandcompany.linkSharing.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.services.SubscriptionService;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(@ModelAttribute("subscrptn") Subscription subscrptn) {
        return subscriptionService.save(subscrptn);

    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseDTO get(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseDTO deleteSubscription(@PathVariable("id") Long id)
    {
        return subscriptionService.delete(id);

    }
}
