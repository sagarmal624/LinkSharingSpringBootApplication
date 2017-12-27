package com.sagarandcompany.linkSharing.utility;

public class ResourceRatingVO {

    private Long resource_rating_id;
    private Long resource_id;
    private Long user_id;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getResource_rating_id() {
        return resource_rating_id;
    }

    public void setResource_rating_id(Long resource_rating_id) {
        this.resource_rating_id = resource_rating_id;
    }

    public Long getResource_id() {
        return resource_id;
    }

    public void setResource_id(Long resource_id) {
        this.resource_id = resource_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


}
