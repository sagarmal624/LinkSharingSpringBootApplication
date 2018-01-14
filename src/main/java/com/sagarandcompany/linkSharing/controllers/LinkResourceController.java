package com.sagarandcompany.linkSharing.controllers;

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

@Controller
@RequestMapping("/resource/link")
public class LinkResourceController extends BaseController {

    @Autowired
    ResourceService resourceService;


    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("resource") LinkResource resource) throws Exception {
        ModelAndView modelAndView = getModalAndView("home");
        if (resource.getTopic() != null && resource.getUrl() != null) {
            ResponseDTO responseDTO = resourceService.save(resource);
            modelAndView.addObject("unreadResources", resourceService.getResources());
            modelAndView.addObject("resource", responseDTO.getData());
            modelAndView.addObject("response", responseDTO);
        } else
            modelAndView.addObject("response", new ResponseDTO("Something went wrong", false, null));

        return modelAndView;
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseDTO getLinkResource(@PathVariable("id") Long id) throws Exception {
        ResponseDTO responseDTO = resourceService.get(id);
        if (responseDTO.getData() == null)
            throw new RecordNotFoundException(LinkSharingKeyword.LINK_SHARING_RESOURCE.getValue());
        return responseDTO;
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseDTO deleteLinkResource(@PathVariable("id") Long id) {
        return resourceService.delete(id);

    }

}
