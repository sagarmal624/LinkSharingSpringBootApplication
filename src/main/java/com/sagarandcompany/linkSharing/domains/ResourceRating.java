package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
public class ResourceRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_rating_id")
    private Long resource_rating_id;
    @OneToOne
    private Resource resource;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private int score;

    public Long getResource_rating_id() {
        return resource_rating_id;
    }

    public void setResource_rating_id(Long resource_rating_id) {
        this.resource_rating_id = resource_rating_id;
    }

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
                "resource_rating_id=" + resource_rating_id +
                ", resource=" + resource +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
