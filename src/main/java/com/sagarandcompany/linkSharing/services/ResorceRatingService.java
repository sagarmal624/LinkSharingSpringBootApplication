package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.ResourceRating;
import com.sagarandcompany.linkSharing.repository.ResourceRatingRepository.ResourceRatingRepoImpl;
import com.sagarandcompany.linkSharing.utility.ResourceRatingDTO;
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


}
