package com.sagarandcompany.linkSharing.domains;

public class ResourceRating {

    private Resource resource;
    private User user;
    private int score;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ResourceRating{" +
                "resource=" + resource +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
