package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.ResourceRating;
import com.sagarandcompany.linkSharing.services.ResorceRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/ResourceRating")
public class ResourceRatingController {

    @Autowired
    ResorceRatingService resorceRatingService;

    @PostMapping("/save")
    @ResponseBody
    public Map save(@ModelAttribute("resorcerating") ResourceRating resourceRating)
    {
        return resorceRatingService.save(resourceRating);

    }


}
