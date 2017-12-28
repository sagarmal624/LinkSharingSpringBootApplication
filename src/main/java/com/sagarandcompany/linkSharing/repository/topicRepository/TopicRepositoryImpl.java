package com.sagarandcompany.linkSharing.repository.topicRepository;

import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        topicList.add(topic);

        session.saveOrUpdate(user);
        session.flush();
        Subscription subscription = new Subscription();
        subscription.setTopic(topic);
        subscription.setUser(user);

        List<Subscription> subscriptions = topic.getSubscriptions();
        subscriptions.add(subscription);
        session = getSession();
        session.saveOrUpdate(topic);

        List<Subscription> userSubscriptions = user.getSubscriptions();
        userSubscriptions.add(subscription);
        session.saveOrUpdate(user);
        session.flush();
        if (topicList.size() == user.getTopics().size())
            return topic;
        else
            return null;
    }


    public Topic getTopic(Long id) {

        Topic topic = getSession().get(Topic.class, id);
        if (topic != null) {
            return topic;
        } else
            return null;
    }


    public Boolean delete(Long id) {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        Topic topic = session.get(Topic.class, id);
        if (topic != null) {

            List<Subscription> subscriptions = user.getSubscriptions();
            subscriptions.removeIf(it -> it.getTopic().getTopic_id() == topic.getTopic_id() && it.getUser().getUser_id() == user.getUser_id());

            List<Topic> topics = user.getTopics();
            topics.removeIf(it -> it.getTopic_id() == topic.getTopic_id());

            session.saveOrUpdate(user);
            session.delete(topic);
            return true;
        }
        return false;
    }

    public Topic getTopicName(String name) {
        Topic topic = getSession().get(Topic.class, name);
        return topic;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
