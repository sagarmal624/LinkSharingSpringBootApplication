package com.sagarandcompany.linkSharing.repository.topicRepository;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TopicRepositoryImpl implements TopicRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Topic save(Topic topic) {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        topic.setCreatedBy(user);

        List<Topic> topicList = user.getTopics();
        if (topicList == null) {
            topicList = new ArrayList<>();
        }
        topicList.add(topic);
        session.saveOrUpdate(user);
        if (topicList.size() == user.getTopics().size())
            return topic;
        else
            return null;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
