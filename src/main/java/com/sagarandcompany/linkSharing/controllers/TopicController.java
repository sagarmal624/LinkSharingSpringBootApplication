package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.services.TopicService;
import com.sagarandcompany.linkSharing.utility.LinkSharingKeyword;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.DataBindingException;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping("/save")
    @ResponseBody
    public ModelAndView save(@ModelAttribute("topic") Topic topic) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseDTO responseDTO = topicService.save(topic);
        modelAndView.addObject("topic", responseDTO.getData());
        modelAndView.addObject("response", responseDTO);
        modelAndView.setViewName("home");
        return modelAndView;


    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseDTO get(@PathVariable("id") Long id) throws Exception {
        ResponseDTO responseDTO = topicService.getTopic(id);
        if (responseDTO.getData() == null)
            throw new RecordNotFoundException(LinkSharingKeyword.TOPIC.getValue());


        return responseDTO;
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseDTO deleteTopic(@PathVariable("id") Long id) {
        return topicService.delete(id);
    }


}
