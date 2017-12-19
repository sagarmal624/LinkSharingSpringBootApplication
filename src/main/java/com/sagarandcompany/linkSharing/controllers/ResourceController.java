package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/Resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;


    @PostMapping("/save")
    @ResponseBody
    public Map save(@ModelAttribute("resource") Resource resource)
    {
        return resourceService.save(resource);

    }


}
