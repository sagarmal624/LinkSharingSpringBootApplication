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
public class DocumentResourceController extends BaseController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/save")
    @ResponseBody
    public ModelAndView save(@ModelAttribute("resource") DocumentResource resource) throws Exception {
        ModelAndView modelAndView = getModalAndView("home");
        if (resource.getTopic() != null && resource.getFile() != null) {
            ResponseDTO responseDTO = resourceService.save(resource);
            modelAndView.addObject("unreadResources", resourceService.getResources());
            modelAndView.addObject("resource", responseDTO.getData());
            modelAndView.addObject("response", responseDTO);
        } else
            modelAndView.addObject("response", new ResponseDTO("Something went wrong", false, null));
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
