package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.DocumentResource;
import com.sagarandcompany.linkSharing.domains.LinkResource;
import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.services.ResourceService;
import com.sagarandcompany.linkSharing.utility.LinkSharingKeyword;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resource/document")
public class DocumentResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(@ModelAttribute("resource") DocumentResource resource) {
        return resourceService.save(resource);

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
