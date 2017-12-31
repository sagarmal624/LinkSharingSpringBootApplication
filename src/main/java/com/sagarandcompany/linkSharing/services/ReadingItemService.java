package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.repository.ReadingItemRepository.ReadingItemImpl;
import com.sagarandcompany.linkSharing.utility.ReadingItemDTO;
import com.sagarandcompany.linkSharing.utility.ReadingItemVO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.hibernate.Session;
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

    public ResponseDTO save(ReadingItemDTO readingItemDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        ReadingItem savedreadingitem = readingItemImpl.save(readingItemDTO);
        if (savedreadingitem != null) {
            responseDTO.setMessageAndStatus(success, true);
        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;
    }

    public ResponseDTO get(Long id) {

        ResponseDTO responseDTO = new ResponseDTO();
        ReadingItem readingItem = readingItemImpl.get(id);
        if (readingItem != null) {
            ReadingItemVO readingItemVO = new ReadingItemVO();
            readingItemVO.setReading_item_id(readingItem.getReading_item_id());
            readingItemVO.setResource_id(readingItem.getResource().getResource_id());
            readingItemVO.setUser_id(readingItem.getUser().getUser_id());
            readingItemVO.setIs_read(readingItem.getRead());
            responseDTO.setData(readingItemVO);
        }
        return responseDTO;
    }

    public ResponseDTO delete(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (readingItemImpl.delete(id)) {
            responseDTO.setMessageAndStatus("Recoed Deleted Successfully", false);
        } else {
            responseDTO.setMessageAndStatus("Something went wrong", false);
        }
        return responseDTO;
    }

}

