package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.services.TopicService;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(@ModelAttribute("topic") Topic topic) {
        return topicService.save(topic);
    }

//    @GetMapping("/get/{id}")
//    @ResponseBody
//    public Topic getTopics(@PathVariable("id") Long id)
//    {
//     return topicService.getTopics(id);
//
//    }

}
