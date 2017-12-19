package com.sagarandcompany.linkSharing.repository.SubscrptnRepository;

import com.sagarandcompany.linkSharing.domains.Subscription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SubscriptionRepositoryimpl implements SubscriptionRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Subscription save(Subscription subscription)
    {
       getSession().save(subscription);
       if(subscription.getSubscription_id()!=null)

       {
           return subscription;
       }
       else
           return null;
    }

    private Session getSession()
    {

        Session session= sessionFactory.getCurrentSession();
        return session;

    }




}
