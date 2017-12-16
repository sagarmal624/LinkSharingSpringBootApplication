package com.sagarandcompany.linkSharing.repository.userRepository;

import com.sagarandcompany.linkSharing.domains.User;
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

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
