package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.controllers.ResourceRatingController;
import com.sagarandcompany.linkSharing.domains.ResourceRating;
import com.sagarandcompany.linkSharing.repository.ResourceRatingRepository.ResourceRatingRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResorceRatingService {

    @Autowired
    ResourceRatingRepoImpl resourceRatingImpl;
     public Map save(ResourceRating resorcerating)
     {
         ResourceRating savedrsrcrtng= resourceRatingImpl.save(resorcerating);
         Map<String, Object> map = new HashMap<>();
         if(savedrsrcrtng!=null)
         {
             map.put("message","Record Saved Successfully");
             map.put("Status","true");
         }
         else
         {
             map.put("message","Record Not Saved");
             map.put("Status","false");

         }
         return map;

     }




}
