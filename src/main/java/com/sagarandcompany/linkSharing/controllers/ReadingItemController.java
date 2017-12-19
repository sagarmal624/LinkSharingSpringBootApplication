package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.services.ReadingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/readingitem")
public class ReadingItemController {

    @Autowired
    ReadingItemService readingItemService;

    public Map save(ReadingItem readingItem)
    {
        return  readingItemService.save(readingItem);
    }


}
