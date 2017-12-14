package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    public Map save(User user) {
        User savedUser = userRepository.saveAndFlush(user);
        Map map = new HashMap();
        if (savedUser.getId() != null) {
            map.put("status", true);
            map.put("message", "record is created successfullyy");
        } else {
            map.put("status", false);
            map.put("message", "record is not Saved successfullyy");
        }
        return map;
    }

    public User findById(Long id) {
        return getSession().get(User.class, id);
    }

    public Session getSession() {

        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
