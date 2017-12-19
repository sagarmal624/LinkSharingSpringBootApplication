package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.repository.ResourceRepository.ResourceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResourceService {
  @Autowired
  ResourceRepositoryImpl resourceRepository;

  public Map save(Resource resource)
  {

      Resource savedresource= resourceRepository.save(resource);
      Map<String, Object> map = new HashMap<>();
       if(savedresource!=null)
       {
           map.put("message","Record Saved Successfully");
           map.put("status",true);
       }
       else
       {
           map.put("message","Record  Not Saved ");
           map.put("status",false);
       }
  return map;
  }
}
