package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.LinkResource;
import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.services.ResourceService;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resource/link")
public class LinkResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(@ModelAttribute("resource") LinkResource resource) {
        return resourceService.save(resource);

    }

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseDTO getLinkResource(@PathVariable("id") Long id) throws Exception {
        return resourceService.get(id);

    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseDTO deleteLinkResource(@PathVariable("id") Long id) {
        return resourceService.delete(id);

    }

}
