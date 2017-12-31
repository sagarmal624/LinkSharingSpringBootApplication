package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.exception.RecordNotFoundException;
import com.sagarandcompany.linkSharing.services.ReadingItemService;
import com.sagarandcompany.linkSharing.utility.LinkSharingKeyword;
import com.sagarandcompany.linkSharing.utility.ReadingItemDTO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/readingitem")
public class ReadingItemController {

    @Autowired
    ReadingItemService readingItemService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO save(@ModelAttribute("readingitem") ReadingItemDTO readingItemDTO) {
        return readingItemService.save(readingItemDTO);
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseDTO getReadingItem(Long id) {
        ResponseDTO responseDTO = readingItemService.get(id);
        if (responseDTO.getData() == null)
            throw new RecordNotFoundException(LinkSharingKeyword.READING_ITEM.getValue());
        return responseDTO;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseDTO deleteReadingItem(@PathVariable("id") Long id) {
        return readingItemService.delete(id);

    }


}
