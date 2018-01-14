package com.sagarandcompany.linkSharing.repository.SubscrptnRepository;

import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.utility.SubscriptionVO;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SubscriptionRepositoryimpl implements SubscriptionRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Subscription get(Long id) {
        if (id != null) {
            Subscription subscription = getSession().get(Subscription.class, id);
            if (subscription != null) {
                return subscription;
            } else
                return null;
        } else
            return null;
    }

    public List<SubscriptionVO> getSubscriptions() throws InvocationTargetException, IllegalAccessException {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        List<Subscription> subscriptions = user.getSubscriptions();

        List<SubscriptionVO> subscriptionVOS = new ArrayList<>();
        for (Subscription subscription : subscriptions) {
            SubscriptionVO subscriptionVO = new SubscriptionVO();
            BeanUtils.copyProperties(subscriptionVO, subscription);
            subscriptionVO.setSubsize(subscriptions.size());
            subscriptionVOS.add(subscriptionVO);
        }
        return subscriptionVOS;

    }

    public Subscription save(Subscription subscription) {

        User user = getSession().get(User.class, User.getLoginUser().getUser_id());
        Topic topic = getSession().get(Topic.class, subscription.getTopic().getTopic_id());
        subscription.setUser(user);
        subscription.setTopic(topic);

        List<Subscription> subscriptions = user.getSubscriptions();
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
        }
        subscriptions.add(subscription);
        getSession().saveOrUpdate(user);
        return subscription;
    }


    public Boolean delete(Long id) {
        Session session = getSession();
        Subscription subscription = session.get(Subscription.class, id);
        SQLQuery sqlQuery = session.createSQLQuery("delete from user_subscription where user_id=" + subscription.getUser().getUser_id() + " and subscription_id=" + id);
        sqlQuery.executeUpdate();
        sqlQuery = session.createSQLQuery("delete from topic_subscription where topic_id=" + subscription.getTopic().getTopic_id() + " and subscription_id=" + id);
        sqlQuery.executeUpdate();
        session.delete(subscription);
        session.flush();
        return true;
    }

    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();
        return session;

    }


}
