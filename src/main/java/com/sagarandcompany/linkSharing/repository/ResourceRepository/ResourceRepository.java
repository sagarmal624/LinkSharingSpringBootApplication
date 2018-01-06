package com.sagarandcompany.linkSharing.repository.ResourceRepository;

import com.sagarandcompany.linkSharing.domains.*;
import com.sagarandcompany.linkSharing.repository.ReadingItemRepository.ReadingItemImpl;
import com.sagarandcompany.linkSharing.repository.ResourceRatingRepository.ResourceRatingRepoImpl;
import com.sagarandcompany.linkSharing.repository.topicRepository.TopicRepositoryImpl;
import com.sagarandcompany.linkSharing.services.CloudnaryService;
import com.sagarandcompany.linkSharing.services.ReadingItemService;
import com.sagarandcompany.linkSharing.utility.ResourceVO;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resources;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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


    @Autowired
    CloudnaryService cloudnaryService;

    public List<ResourceVO> getResourcesList() {
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        List<Topic> topics = user.getTopics();
        List<ResourceVO> resourceVOS = new ArrayList<>();
        for (Topic topic : topics) {
            List<Resource> resourceList = topic.getResources();
            for (Resource resource : resourceList) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setResource_id(resource.getResource_id());
                resourceVO.setDescription(resource.getDescription());
                resourceVO.setResourceCreatedBy(topic.getCreatedBy().getFullname());
                if (resource instanceof LinkResource) {
                    LinkResource linkResource = (LinkResource) resource;
                    resourceVO.setUrl(linkResource.getUrl());
                } else {
                    DocumentResource documentResource = (DocumentResource) resource;
                    resourceVO.setUrl(documentResource.getFilePath());
                }
                resourceVOS.add(resourceVO);
            }
        }
        return resourceVOS;
    }


    public Resource save(Resource resource) {
        Session session = getSession();
        Topic topic = session.get(Topic.class, resource.getTopic().getTopic_id());
        User user = getSession().get(User.class, User.getLoginUser().getUser_id());
        resource.setCreatedBy(user);
        resource.setTopic(topic);

        List<Resource> resources = topic.getResources();

        resources.add(resource);
        if (resource instanceof DocumentResource) {
            if (((DocumentResource) resource).getFile().getOriginalFilename() != null) {
                ((DocumentResource) resource).setFilePath(cloudnaryService.upload(((DocumentResource) resource).getFile()));
            }
        }
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
