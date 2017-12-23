package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.repository.ReadingItemRepository.ReadingItemImpl;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReadingItemService {

    @Autowired
    ReadingItemImpl readingItemImpl;

    @Value("${linksharing.readingitem.success}")
    private String success;

    @Value("${linksharing.readingitem.error}")
    private String error;

    public ResponseDTO save(ReadingItem readingItem) {
        ResponseDTO responseDTO = new ResponseDTO();
        ReadingItem savedreadingitem = readingItemImpl.save(readingItem);
        if (savedreadingitem != null) {
            responseDTO.setMessageAndStatus(success, true);
        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;
    }

}
