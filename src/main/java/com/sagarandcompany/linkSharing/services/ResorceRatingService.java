package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.ResourceRating;
import com.sagarandcompany.linkSharing.repository.ResourceRatingRepository.ResourceRatingRepoImpl;
import com.sagarandcompany.linkSharing.utility.ResourceRatingDTO;
import com.sagarandcompany.linkSharing.utility.ResourceRatingVO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ResorceRatingService {

    @Autowired
    ResourceRatingRepoImpl resourceRatingImpl;

    @Value(" ${linksharing.resourcerating.success}")
    private String success;

    @Value("${linksharing.resourcerating.error}")
    private String error;

    public ResponseDTO save(ResourceRatingDTO resourceRatingDTO) {

        ResponseDTO responseDTO = new ResponseDTO();
        ResourceRating savedrsrcrtng = resourceRatingImpl.save(resourceRatingDTO);
        if (savedrsrcrtng != null) {
            responseDTO.setMessageAndStatus(success, true);
        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;

    }

     public ResponseDTO get(long id)
     {
         ResponseDTO responseDTO=new ResponseDTO();
         ResourceRatingVO resourceRatingVO=new ResourceRatingVO();
         ResourceRating resourceRating=resourceRatingImpl.get(id);
         if(resourceRating!=null) {
             resourceRatingVO.setResource_rating_id(resourceRating.getResource_rating_id());
             resourceRatingVO.setResource_id(resourceRating.getResource().getResource_id());
             resourceRatingVO.setScore(resourceRating.getScore());
             resourceRatingVO.setUser_id(resourceRating.getUser().getUser_id());
             responseDTO.setData(resourceRatingVO);

         }
         else
             responseDTO.setMessageAndStatus("Record Not found",false);

         return responseDTO;
     }

     public ResponseDTO delete(Long id)
     {
         ResponseDTO responseDTO=new ResponseDTO(false);
         if(resourceRatingImpl.delete(id))
         {
            responseDTO.setMessageAndStatus("Record Deleted Successfully",true);

         }
         else
         {
             responseDTO.setMessageAndStatus("Something went wrong",false);
         }
         return responseDTO;
     }

}
