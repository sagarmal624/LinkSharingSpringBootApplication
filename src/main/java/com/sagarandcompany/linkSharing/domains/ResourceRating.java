package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
public class ResourceRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_rating_id")
    private Long resource_rating_id;
    private Long resourceId;
    private Long userId;
    private int score;

    public Long getResource_rating_id() {
        return resource_rating_id;
    }

    public void setResource_rating_id(Long resource_rating_id) {
        this.resource_rating_id = resource_rating_id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
