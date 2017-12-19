package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.repository.ReadingItemRepository.ReadingItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReadingItemService {

@Autowired
   ReadingItemImpl readingItemImpl;
  public Map save(ReadingItem readingItem)
  {
      ReadingItem savedreadingitem=readingItemImpl.save(readingItem);
      Map<String, Object> map = new HashMap<>();
      if(savedreadingitem!=null)
      {
          map.put("message","Record Saved Successfully");
          map.put("status" , true);

      }
      else
      {
          map.put("message","Record not Saved ");
          map.put("status" , false);

      }
  return map;
  }

}
