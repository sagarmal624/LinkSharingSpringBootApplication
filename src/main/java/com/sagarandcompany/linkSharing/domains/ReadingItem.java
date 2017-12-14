package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
public class ReadingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Resource resource;
    @OneToOne
    private User user;
    private boolean isRead;

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

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "ReadingItem{" +
                "resource=" + resource +
                ", user=" + user +
                ", isRead=" + isRead +
                '}';
    }
}
