package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
public class ResourceRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_rating_id")
    private Long id;
    @OneToOne
    private Resource resource;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "resource=" + resource +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
