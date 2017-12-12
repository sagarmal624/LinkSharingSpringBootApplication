package com.sagarandcompany.linkSharing.domains;

import java.util.Date;

public class Subscription
{
    private Topic topic;
    private User user;
    private Date datecreated;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "topic=" + topic +
                ", user=" + user +
                ", datecreated=" + datecreated +
                '}';
    }
}
