package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
public class Subscription extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Topic topic;
    @OneToOne
    private User user;

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
