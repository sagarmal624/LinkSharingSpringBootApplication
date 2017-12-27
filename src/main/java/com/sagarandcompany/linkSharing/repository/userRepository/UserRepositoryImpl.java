package com.sagarandcompany.linkSharing.repository.userRepository;

import com.sagarandcompany.linkSharing.domains.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public User save(User user) {
        getSession().save(user);
        return user;
    }

    public User findByUser(Long id) {
        return getSession().get(User.class, id);
    }

    public Boolean delete(Long id) {
        Session session = getSession();

        User user = session.get(User.class, id);
        if (user != null) {
            Query deleteRatingQuery = session.createQuery("delete from ResourceRating where user=:user");
            deleteRatingQuery.setParameter("user", user);
            deleteRatingQuery.executeUpdate();


            SQLQuery deleteUserReadingItemQuery = session.createSQLQuery("delete from user_reading_item where user_id=" + user.getUser_id());
            deleteUserReadingItemQuery.executeUpdate();

            Query deleteReadingItemQuery = session.createQuery("delete from ReadingItem where user=:user");
            deleteReadingItemQuery.setParameter("user", user);
            deleteReadingItemQuery.executeUpdate();

            session.delete(user);
            return true;
        } else
            return false;
    }

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
