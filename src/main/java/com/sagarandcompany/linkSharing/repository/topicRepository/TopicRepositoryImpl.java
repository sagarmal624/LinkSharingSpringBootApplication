package com.sagarandcompany.linkSharing.repository.topicRepository;

import com.sagarandcompany.linkSharing.domains.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepositoryImpl implements TopicRepository {
    private SessionFactory sessionFactory;

    public Topic save(Topic topic) {
        getSession().save(topic);
        if (topic.getTopic_id() != null)
            return topic;
        else
            return null;

    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
