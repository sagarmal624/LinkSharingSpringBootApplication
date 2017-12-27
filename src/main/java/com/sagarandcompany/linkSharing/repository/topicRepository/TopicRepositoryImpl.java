package com.sagarandcompany.linkSharing.repository.topicRepository;

import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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


    public Topic getTopic(Long id) {

        Topic topic = getSession().get(Topic.class, id);
        if (topic != null) {
            return topic;
        } else
            return null;
    }


    public Boolean delete(Long id) {

        Session session = getSession();
        Topic topic = session.get(Topic.class, id);
        /*if (topic != null) {
            SQLQuery deleteUserTopic = session.createSQLQuery("delete from user_topics where topic_id=" + topic.getTopic_id());
            deleteUserTopic.executeUpdate();

        */
        session.delete(topic);

        //Query deleteTopicQuery= session.createQuery("delete from Topic where topic_id= '"+topic.getTopic_id()+"' and createdBy='"+user.getUser_id()+"'");
        // deleteTopicQuery.setParameter("topic", topic);
        //  deleteTopicQuery.setParameter("user",user);
//            deleteTopicQuery.executeUpdate();


        return true;
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
