package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
public class ReadingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reading_item_id")
    private Long reading_item_id;
    @OneToOne(cascade = CascadeType.ALL)
    private Resource resource;
    @OneToOne
    private User user;
    private Boolean isRead;


    public Long getReading_item_id() {
        return reading_item_id;
    }

    public void setReading_item_id(Long reading_item_id) {
        this.reading_item_id = reading_item_id;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
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


    @Override
    public String toString() {
        return "ReadingItem{" +
                "reading_item_id=" + reading_item_id +
                ", resource=" + resource +
                ", user=" + user +
                ", isRead=" + isRead +
                '}';
    }
}
