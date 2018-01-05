package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.DocumentResource;
import com.sagarandcompany.linkSharing.domains.LinkResource;
import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.services.ResourceService;
import com.sagarandcompany.linkSharing.utility.LinkSharingKeyword;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import com.sagarandcompany.linkSharing.utility.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.Document;
import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/resource/document")
public class DocumentResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/save")
    @ResponseBody
    public ModelAndView save(@ModelAttribute("resource") DocumentResource resource) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseDTO responseDTO = resourceService.save(resource);

        modelAndView.addObject("topic", new TopicVO());
        modelAndView.addObject("resource", responseDTO.getData());
        modelAndView.addObject("response", responseDTO);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseDTO getDocumentResource(@PathVariable("id") Long id) throws Exception {
        ResponseDTO responseDTO = resourceService.get(id);
        if (responseDTO.getData() == null)
            throw new RecordNotFoundException(LinkSharingKeyword.DOCUMENT_SHARING_RESOURCE.getValue());
        return responseDTO;

    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseDTO deleteDocumentResource(@PathVariable("id") Long id) {
        return resourceService.delete(id);

    }
}
