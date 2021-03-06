package com.sagarandcompany.linkSharing.repository.ResourceRepository;

import com.sagarandcompany.linkSharing.domains.*;
import com.sagarandcompany.linkSharing.repository.ReadingItemRepository.ReadingItemImpl;
import com.sagarandcompany.linkSharing.repository.ResourceRatingRepository.ResourceRatingRepoImpl;
import com.sagarandcompany.linkSharing.repository.topicRepository.TopicRepositoryImpl;
import com.sagarandcompany.linkSharing.services.ReadingItemService;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
    @Autowired
    ReadingItemImpl readingItem;
    @Autowired
    ResourceRatingRepoImpl resourceRatingRepo;

    @Autowired
    TopicRepositoryImpl topicRepository;

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
            SQLQuery sqlQuery = session.createSQLQuery("delete from topic_resource where topic_id=" + resource.getTopic().getTopic_id() + " and resource_id=" + resource.getResource_id());
            sqlQuery.executeUpdate();
            readingItem.deleteByResource(resource);
            resourceRatingRepo.deleteByResource(resource);
            session.delete(resource);
            return true;
        }
        return false;
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }


}
