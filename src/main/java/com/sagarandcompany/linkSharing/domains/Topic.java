package com.sagarandcompany.linkSharing.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Topic {
    @Id
    private Long id;
    private String name;
    //    private User createdBy;
    private Date dateCreated;
    private Date lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public User getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(User createdBy) {
//        this.createdBy = createdBy;
//    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

//    @Override
//    public String toString() {
//        return "Topic{" +
//                "name='" + name + '\'' +
//                ", createdBy=" + createdBy +
//                ", dateCreated=" + dateCreated +
//                ", lastUpdated=" + lastUpdated +
//                '}';
//    }
}
