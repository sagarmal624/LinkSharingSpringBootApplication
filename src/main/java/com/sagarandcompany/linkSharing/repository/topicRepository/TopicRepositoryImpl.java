package com.sagarandcompany.linkSharing.repository.topicRepository;

import com.sagarandcompany.linkSharing.domains.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TopicRepositoryImpl implements TopicRepository {
    @Autowired
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
