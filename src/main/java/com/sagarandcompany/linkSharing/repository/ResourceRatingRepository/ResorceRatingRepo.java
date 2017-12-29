package com.sagarandcompany.linkSharing.repository.ResourceRatingRepository;

import com.sagarandcompany.linkSharing.domains.ResourceRating;
import com.sagarandcompany.linkSharing.utility.ResourceRatingDTO;

public interface ResorceRatingRepo {
    public ResourceRating save(ResourceRatingDTO resourceRatingDTO);
}
