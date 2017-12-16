package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
public class Subscription extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subscription_id")
    private Long subscription_id;
    @OneToOne
    private Topic topic;
    @OneToOne
    private User user;

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
                "topic=" + topic +
                ", user=" + user +

                '}';
    }
}
