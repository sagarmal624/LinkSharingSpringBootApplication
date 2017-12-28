package com.sagarandcompany.linkSharing.repository.ResourceRepository;

import com.sagarandcompany.linkSharing.domains.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
        resources.add(resource);
        session.save(topic);
        return resource;
    }

    public Resource get(Long id) {
        Resource resource = getSession().get(Resource.class, id);
        return resource;
    }

    public Boolean delete(Long id) {
        Session session = getSession();

        Resource resource = session.get(Resource.class, id);
        if (resource != null) {
            Criteria criteria = session.createCriteria(ReadingItem.class);
            criteria.createAlias("resource", "r");
            criteria.add(Restrictions.eq("r.resource_id", resource.getResource_id()));
            if (criteria.list().size() != 0) {
                ReadingItem readingItem = (ReadingItem) criteria.list().get(0);
                User user = session.get(User.class, User.getLoginUser().getUser_id());

                List<ReadingItem> readingItems = user.getReadingitems();
                readingItems.removeIf(it -> it.getReading_item_id() == readingItem.getReading_item_id());
                session.saveOrUpdate(user);
                session.delete(readingItem);
                session.flush();
                session = getSession();
            }
            Criteria criteria2 = session.createCriteria(ResourceRating.class);
            criteria2.add(Restrictions.eq("resource", resource));
            if (criteria2.list().size() != 0) {
                ResourceRating resourceRating = (ResourceRating) criteria2.list().get(0);
                session.delete(resourceRating);
                session.flush();
                session = getSession();
            }
            Topic topic = resource.getTopic();
            List<Resource> resources = topic.getResources();
            resources.removeIf(it -> it.getResource_id() == resource.getResource_id());
            session.saveOrUpdate(topic);
            session.delete(resource);
            session.flush();
            return true;
        }
        return false;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }


}
