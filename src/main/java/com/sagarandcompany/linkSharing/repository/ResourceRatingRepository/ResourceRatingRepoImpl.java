package com.sagarandcompany.linkSharing.repository.ResourceRatingRepository;

import com.sagarandcompany.linkSharing.domains.LinkResource;
import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.domains.ResourceRating;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.utility.ResourceRatingDTO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ResourceRatingRepoImpl implements ResorceRatingRepo {

    @Autowired
    private SessionFactory sessionFactory;


    public ResourceRating save(ResourceRatingDTO resourceRatingDTO) {
        ResourceRating resourceRating = new ResourceRating();
        resourceRating.setScore(resourceRatingDTO.getScore());

        User user = getSession().get(User.class, User.getLoginUser().getUser_id());
        Resource resource = getSession().get(Resource.class, resourceRatingDTO.getResource_id());
        resourceRating.setUser(user);
        resourceRating.setResource(resource);

        getSession().save(resourceRating);
        if (resourceRating.getResource_rating_id() != null)
            return resourceRating;
        else
            return null;

    }

    public ResourceRating get(Long id)
    {
        if(id!=null) {
            ResourceRating resourceRating = getSession().get(ResourceRating.class, id);
            if (resourceRating != null) {
                return resourceRating;
            } else
                return null;
        }
        else
            return null;
    }

     public Boolean delete(Long id)
     {
        Session session=getSession();
        ResourceRating resourceRating=getSession().get(ResourceRating.class,id);
            session.delete(resourceRating);
            return true;

     }
    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
