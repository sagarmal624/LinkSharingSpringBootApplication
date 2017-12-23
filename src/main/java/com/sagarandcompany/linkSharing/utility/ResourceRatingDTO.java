package com.sagarandcompany.linkSharing.utility;

import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.domains.User;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class ResourceRatingDTO {
    private Long resource_id;
    private int score;

    public Long getResource_id() {
        return resource_id;
    }

    public void setResource_id(Long resource_id) {
        this.resource_id = resource_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
