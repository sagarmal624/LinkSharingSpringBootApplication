package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping("/save")
    public Map save(@ModelAttribute("topic") Topic topic) {
        return topicService.save(topic);
    }
}
