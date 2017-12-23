package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.services.ReadingItemService;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/readingitem")
public class ReadingItemController {

    @Autowired
    ReadingItemService readingItemService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(ReadingItem readingItem) {
        return readingItemService.save(readingItem);
    }


}
