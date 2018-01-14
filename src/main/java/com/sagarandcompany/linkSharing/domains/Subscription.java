package com.sagarandcompany.linkSharing.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sagarandcompany.linkSharing.utility.Seriousness;

import javax.persistence.*;

@Entity
public class Subscription extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscription_id")
    private Long subscription_id;
    @OneToOne
    @JoinColumn(nullable = false)
    private Topic topic;
    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    private Seriousness seriousness;

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }

    public Long getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(Long subscription_id) {
        this.subscription_id = subscription_id;
    }

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

    @Override
    public String toString() {
        return "Subscription{" +
                "subscription_id=" + subscription_id +
                ", topic=" + topic +
                ", user=" + user +
                '}';
    }
}
