package com.sagarandcompany.linkSharing.repository.SubscrptnRepository;

import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

       /*getSession().save(subscription);
       if(subscription.getSubscription_id()!=null)

       {
           return subscription;
       }
       else
           return null;
    }

*/



       public Boolean delete(Long id)
       {
           Session session=getSession();
          Subscription subscription= session.get(Subscription.class,id);
              session.delete(subscription);
              return true;

       }
    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();
        return session;

    }


}
