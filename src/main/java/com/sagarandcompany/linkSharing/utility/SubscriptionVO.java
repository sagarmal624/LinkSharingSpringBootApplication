package com.sagarandcompany.linkSharing.utility;

public class SubscriptionVO {
    private Long subscription_id;
    private Long topic_id;
    private Long user_id;
    private int subsize;

    public int getSubsize() {
        return subsize;
    }

    public void setSubsize(int subsize) {
        this.subsize = subsize;
    }

    public Long getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(Long subscription_id) {
        this.subscription_id = subscription_id;
    }

    public Long getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
