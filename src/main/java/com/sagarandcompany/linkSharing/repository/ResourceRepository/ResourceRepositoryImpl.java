package com.sagarandcompany.linkSharing.repository.ResourceRepository;

import com.sagarandcompany.linkSharing.domains.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ResourceRepositoryImpl implements  ResourceRepository{
   @Autowired
    SessionFactory sessionFactory;

    public Resource save(Resource resource)
    {
        Resource resourceses= (Resource) getSession().save(resource);
        if(resourceses.getResource_id()!=null)
        return resourceses;
        else
            return null;
    }

    private Session getSession()
    {

        Session session=sessionFactory.getCurrentSession();
        return session;

    }


}
