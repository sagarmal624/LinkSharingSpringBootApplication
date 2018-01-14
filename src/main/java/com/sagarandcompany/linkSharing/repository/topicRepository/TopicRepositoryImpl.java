package com.sagarandcompany.linkSharing.repository.topicRepository;

import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.utility.Seriousness;
import com.sagarandcompany.linkSharing.utility.TopicVO;
import com.sagarandcompany.linkSharing.utility.UserVO;
//import org.apache.commons.beanutils.BeanUtils;
import com.sagarandcompany.linkSharing.utility.Visibility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TopicRepositoryImpl implements TopicRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<TopicVO> getTopics(List<Topic> topics)

    {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());

        List<TopicVO> topicVOS = new ArrayList<>();
        for (Topic topic : topics) {
            TopicVO topicVO = new TopicVO();
            UserVO userVO = new UserVO();
            topicVO.setTopicsize(topics.size());
            BeanUtils.copyProperties(topic, topicVO, "createdBy");
            BeanUtils.copyProperties(topic.getCreatedBy(), userVO);
            topicVO.setCreatedBy(userVO);
            topicVO.setSubscriptionCount(topic.getSubscriptions().size());
            topicVO.setPostCount(topic.getResources().size());
            Criteria criteria = session.createCriteria(Subscription.class);
            criteria.add(Restrictions.eq("user", user));
            criteria.add(Restrictions.eq("topic", topic));
            List<Subscription> subscriptions = criteria.list();
            if (subscriptions.size() != 0) {
                topicVO.setSeriousness(subscriptions.get(0).getSeriousness());
                topicVO.setSubscribed(true);
                topicVO.setSubscriptionId(subscriptions.get(0).getSubscription_id());
            } else
                topicVO.setSubscribed(false);

            topicVOS.add(topicVO);
        }
        return topicVOS;
    }

    public List<TopicVO> getTopicList() throws InvocationTargetException, IllegalAccessException {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        List<Topic> topics = user.getTopics();
        return getTopics(topics);
    }

    public List<TopicVO> getTrendingTopicList() throws InvocationTargetException, IllegalAccessException {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        Criteria criteria = session.createCriteria(Topic.class);
        criteria.add(Restrictions.eq("visibility", Visibility.PUBLIC));
        List<Topic> topics = (List<Topic>) criteria.list();
        return getTopics(topics);
    }

    public Topic save(Topic topic) {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        topic.setCreatedBy(user);
        List<Topic> topicList = user.getTopics();
        topicList.add(topic);

        session.saveOrUpdate(user);
        session.flush();
        Subscription subscription = new Subscription();
        subscription.setSeriousness(Seriousness.SERIOUS);
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

    public Boolean removeResourceFromTopic(Resource resource) {
        Session session = getSession();
        Topic topic = resource.getTopic();
        topic.getResources().removeIf(it -> it.getResource_id() == resource.getResource_id());
        session.save(topic);
        session.flush();
        //        SQLQuery sqlQuery = session.createSQLQuery("delete from topic_resource where topic_id=" + resource.getTopic().getTopic_id() + " and resource_id=" + resource.getResource_id());
//        sqlQuery.executeUpdate();
//        session.flush();

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
