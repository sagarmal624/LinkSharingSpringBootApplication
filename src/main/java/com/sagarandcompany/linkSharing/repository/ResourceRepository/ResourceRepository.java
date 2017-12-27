package com.sagarandcompany.linkSharing.repository.ResourceRepository;

import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.domains.Topic;
import com.sagarandcompany.linkSharing.domains.User;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public abstract class ResourceRepository {
    @Autowired
    SessionFactory sessionFactory;

    public Resource save(Resource resource) {
        Session session = getSession();
        Topic topic = session.get(Topic.class, resource.getTopic().getTopic_id());
        User user = getSession().get(User.class, User.getLoginUser().getUser_id());
        resource.setCreatedBy(user);
        resource.setTopic(topic);

        List<Resource> resources = topic.getResources();
        if (resources == null) {
            resources = new ArrayList<>();
        }

        resources.add(resource);
        session.save(topic);
        return resource;
    }

    public Resource get(Long id)
    {
       Resource resource= getSession().get(Resource.class,id);
       return resource;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

}
